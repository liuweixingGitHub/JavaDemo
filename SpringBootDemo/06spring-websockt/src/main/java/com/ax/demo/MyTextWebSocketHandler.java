package com.ax.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

public class MyTextWebSocketHandler extends TextWebSocketHandler {


    private Map<String, WebSocketSession> allClient = new HashMap<>();

    /**
     * 建立连接
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        /**获取拦截中的id,这个是连接人的id*/
//        Long id = (long) session.getAttributes().get("userid");
//        allClient.put(id.toString(), session);


        System.out.println("建立连接 allClient = " + allClient);

        super.afterConnectionEstablished(session);
    }


    /**
     * 调用连接
     *
     * @param session 当前发送消息的连接
     * @param message 消息内容
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        System.out.println("获取到消息payload = " + payload);

//        String msg = new String(message.asBytes());
        JSONObject jsonObject = JSON.parseObject(payload);
//
//        System.out.println("msg = " + msg);

        /**这里是接收方的id*/
        Long toId = jsonObject.getLong("toId");
        System.out.println("toId = " + toId);
//        TextMessage textMessage = new TextMessage(msg);

        sendMsg(toId,message);
    }

    public void sendMsg(Long userid, TextMessage textMessage){

        System.out.println("sendMsg allClient = " + allClient);

        /**获取对方连接*/
        WebSocketSession session = allClient.get(String.valueOf(userid));

        System.out.println("session = " + session);

        if (session !=null && session.isOpen()){

            try {
                /*发送消息*/
                session.sendMessage(textMessage);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        /**获取拦截中的id,这个是连接人的id*/
        Long id = (long) session.getAttributes().get("userid");
        allClient.put(id.toString(), session);

        System.out.println("关闭连接 allClient = " + allClient);


    }
}
