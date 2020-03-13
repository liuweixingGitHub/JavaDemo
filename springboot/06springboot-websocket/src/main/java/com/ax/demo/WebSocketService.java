package com.ax.demo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author liuqin
 * @Description: 给所用户所有终端推送消息
 * @date 2018年3月19日 下午3:21:31
 */
//websocket连接URL地址和可被调用配置
//@ServerEndpoint(value="/ws/{id}")
@ServerEndpoint(value = "/{ws}")
@Service
public class WebSocketService {

    //日志记录      
    private Logger logger = LoggerFactory.getLogger(WebSocketService.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //记录每个用户下多个终端的连接
    private static Map<Long, Set<WebSocketService>> userSocketMap = new HashMap<>();

    //需要session来对用户发送数据, 获取连接特征userId
    private Session session;
    private Long userId;

    /**
     * @param @param  userId 用户id
     * @param @param  session websocket连接的session属性
     * @param @throws IOException
     * @Title: onOpen
     * @Description: websocekt连接建立时的操作
     */
    @OnOpen
//    public void onOpen(@PathParam("id") Long userId, Session session) throws IOException{
    public void onOpen(@PathParam("ws") String type, Session session) throws IOException {
        /*从请求中获取参数*/
        String id = session.getRequestParameterMap().get("id").get(0);
        System.out.println("onOpen id = " + id);

        System.out.println("type = " + type);
/*
        Map<String, String> map = session.getPathParameters();
        System.out.println("session.getPathParameters()" + map.toString());


        String str = session.getQueryString();

        System.out.println("session.getQueryString()" + str);

        String uri = session.getRequestURI().toString();
        System.out.println("session.getRequestURI().toString()" + uri);


        System.out.println("getUserProperties = " + session.getUserProperties());

        System.out.println("getRequestParameterMap = " + session.getRequestParameterMap());*/


        this.session = session;
        this.userId = Long.valueOf(id);

        onlineCount++;
        //根据该用户当前是否已经在别的终端登录进行添加操作
        if (userSocketMap.containsKey(this.userId)) {
            logger.debug("当前用户id:{}已有其他终端登录", this.userId);
            userSocketMap.get(this.userId).add(this); //增加该用户set中的连接实例
        } else {
            logger.debug("当前用户id:{}第一个终端登录", this.userId);
            Set<WebSocketService> addUserSet = new HashSet<>();
            addUserSet.add(this);
            userSocketMap.put(this.userId, addUserSet);
        }
        logger.info("用户{}登录的终端个数是为{}", userId, userSocketMap.get(this.userId).size());
        logger.info("当前在线用户数为：{},所有终端个数为：{}", userSocketMap.size(), onlineCount);
    }

    /**
     * @Title: onClose
     * @Description: 连接关闭的操作
     */
    @OnClose
    public void onClose() {
        onlineCount--;
        //移除当前用户终端登录的websocket信息,如果该用户的所有终端都下线了，则删除该用户的记录
        if (userSocketMap.get(this.userId).size() == 0) {
            userSocketMap.remove(this.userId);
        } else {
            userSocketMap.get(this.userId).remove(this);
        }
        logger.info("用户{}登录的终端个数是为{}", this.userId, userSocketMap.get(this.userId).size());
        logger.info("当前在线用户数为：{},所有终端个数为：{}", userSocketMap.size(), onlineCount);
    }

    /**
     * @param @param message 收到的消息
     * @param @param session 该连接的session属性
     * @Title: onMessage
     * @Description: 收到消息后的操作
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到来自用户id为：{}的消息：{}", this.userId, message);
        if (session == null) logger.info("session null");

        JSONObject jsonObject = JSON.parseObject(message);
        Long toId = jsonObject.getLong("toId");
        sendMessageToUser(toId, message);

    }

    /**
     * @param @param session 该连接的session
     * @param @param error 发生的错误
     * @Title: onError
     * @Description: 连接发生错误时候的操作
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("用户id为：{}的连接发送错误", this.userId);
        error.printStackTrace();
    }

    /**
     * @param @param  userId 用户id
     * @param @param  message 发送的消息
     * @param @return 发送成功返回true，反则返回false
     * @Title: sendMessageToUser
     * @Description: 发送消息给用户下的所有终端
     */
    public Boolean sendMessageToUser(Long userId, String message) {

        if (userSocketMap.containsKey(userId)) {
            logger.info(" 给用户id为：{}的所有终端发送消息：{}", userId, message);
            for (WebSocketService WS : userSocketMap.get(userId)) {
                logger.info("sessionId为:{}", WS.session.getId());
                try {
                    WS.session.getBasicRemote().sendText(message);
                    logger.info(" 给用户id为：{}发送消成功", userId);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info(" 给用户id为：{}发送消息失败", userId);
                    return false;
                }
            }
            return true;
        }
        logger.info("发送错误：当前连接不包含id为：{}的用户", userId);
        return false;
    }

}