package com.ax.shop.listener.redis;

import com.ax.shop.service.impl.RedisService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 监听所有db的过期事件__keyevent@*__:expired"
 * @author lsm
 */
//@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对redis数据失效事件，进行数据处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key

        String channel = new String(message.getChannel());
//        String key = new String(message.getBody());

        String key = message.toString();

        System.out.println("channel = " + channel);
        System.out.println("key = " + key);

        if(key.startsWith(RedisService.REDIS_VALUE_IPLOG)){
            //如果是Order:开头的key，进行处理
        }
    }
}