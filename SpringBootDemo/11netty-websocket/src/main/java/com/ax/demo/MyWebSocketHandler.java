package com.ax.demo;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.*;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.Map;

public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");

        //添加到channelGroup通道组
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
        //添加到channelGroup 通道组
        MyChannelHandlerPool.channelGroup.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("客户端收到服务器数据：" + msg.text());
        String msgText = msg.text();
        JSONObject jsonObject = JSONObject.parseObject(msgText);
        Map<String, Object> map = jsonObject;
        String longId = ctx.channel().id().asLongText();
        if (map.containsKey("login")) {
            login(map, ctx.channel().id());
        } else {
            sendToSomeone(map);
        }
    }

    //ping、pong
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //用于触发用户事件，包含触发读空闲、写空闲、读写空闲
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.ALL_IDLE) {
                Channel channel = ctx.channel();
                //关闭无用channel，以防资源浪费
                channel.close();
            }
        }
    }

    private void sendAllMessage(String message) {
        //收到信息后，群发给所有channel
        MyChannelHandlerPool.channelGroup.writeAndFlush(new TextWebSocketFrame(message));
    }

    private void sendToSomeone(Map<String, Object> map) {
//        ChannelId channelId = (ChannelId) redisOperator.getObject(6, map.get("toId").toString());
        ChannelId fromId = MyChannelHandlerPool.channelIdMap.get(map.get("fromId"));
        ChannelFuture channelFuture = MyChannelHandlerPool.channelGroup.find(fromId).writeAndFlush(new TextWebSocketFrame(map.toString()));


        ChannelId toId = MyChannelHandlerPool.channelIdMap.get(map.get("toId"));
        MyChannelHandlerPool.channelGroup.find(toId).writeAndFlush(new TextWebSocketFrame(map.toString()));
    }

    private void login(Map<String, Object> map, ChannelId channelId) {
        String uid = map.get("login").toString();
//        redisOperator.set(6, uid, channelId);
        MyChannelHandlerPool.channelIdMap.put(uid, channelId);
    }
}