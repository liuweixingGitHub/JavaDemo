package com.ax.shop.configuration;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.ax.shop.listener.redis.OrderMessageListener;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


/**
 * Redis缓存配置类
 *
 * @author 2020-01-04
 */
//@Configuration
///**Redis 是否可用*/
//@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


/*    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                System.out.println("o = " + o);
                return method.getName() + Arrays.asList(objects).toString();
            }
        };
    }*/

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);

        RedisCacheManager manager = RedisCacheManager
                .builder(redisCacheWriter)
                .cacheDefaults(redisCacheConfiguration(-1))
//                .initialCacheNames(cacheNames.build())
                .withInitialCacheConfigurations(initialCacheConfigurations())
                .build();

        return manager;
    }

    private RedisSerializer<Object> redisSerializer() {
//        FastJsonRedisSerializer<Object> redisSerializer = new FastJsonRedisSerializer<>(Object.class);
//        return redisSerializer;
        return new GenericFastJsonRedisSerializer();
    }

    private RedisCacheConfiguration redisCacheConfiguration(long seconds) {

        RedisSerializationContext.SerializationPair serializationPair =
                RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer());

        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(seconds))
                .serializeValuesWith(serializationPair);
        return configuration;

    }

    private Map<String, RedisCacheConfiguration> initialCacheConfigurations() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();

        //设置@Cacheable(value  过期时间
//        redisCacheConfigurationMap.put(RedisService.REDIS_VALUE_IPLOG,redisCacheConfiguration(5));

        return redisCacheConfigurationMap;
    }

    /**
     * 初始化监听器
     */
    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory,
                                                                OrderMessageListener orderMessageListener) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //container.addMessageListener(orderMessageListenerAdapter, new PatternTopic("__keyevent@0__:expired"));//这个是key失效频道
//        container.addMessageListener(orderMessageListener, new PatternTopic(RedisService.REDIS_VALUE_IPLOG));
        return container;
    }

    @Bean
    OrderMessageListener orderMessageListenerAdapter() {
        return new OrderMessageListener();
    }


}





