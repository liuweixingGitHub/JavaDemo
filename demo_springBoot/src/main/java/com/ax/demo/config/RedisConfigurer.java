package com.ax.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.ax.demo.listener.redis.OrderMessageListener;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


/**
 * Redis缓存配置类
 *
 * @author liuyazhuang
 */
//@Configuration
//@EnableCaching
public class RedisConfigurer extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),

                // 默认策略，未配置的 key 会使用这个
                this.redisCacheConfiguration(-1),

                // 指定 key 策略
                this.redisCacheConfigurationMap()
        );
    }


    private RedisCacheConfiguration redisCacheConfiguration(Integer seconds) {

        FastJsonRedisSerializer<Object> redisSerializer = new FastJsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);



        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(redisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));


        return redisCacheConfiguration;
    }

    private Map<String, RedisCacheConfiguration> redisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();

        //设置@Cacheable(value  过期时间
//        redisCacheConfigurationMap.put(RedisService.REDIS_VALUE_IPLOG, this.redisCacheConfiguration(5));

        return redisCacheConfigurationMap;
    }


    /**
     * 初始化监听器
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            OrderMessageListener orderMessageListener) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //container.addMessageListener(orderMessageListenerAdapter, new PatternTopic("__keyevent@0__:expired"));//这个是key失效频道
        container.addMessageListener(orderMessageListener, new PatternTopic("channel_order"));
        return container;
    }

    @Bean
    OrderMessageListener orderMessageListenerAdapter() {
        return new OrderMessageListener();
    }



}





