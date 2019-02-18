package com.ax.study.all.config.cache;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
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
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuffer stringBuffer = new StringBuffer();
//                stringBuffer.append(target.getClass().getName());
//                stringBuffer.append(method.getName());
//                for (Object obj : params) {
//                    stringBuffer.append(JSON.toJSONString(obj, SerializerFeature.WriteClassName).hashCode());
//                }
//                return stringBuffer.toString();
//            }
//        };
//    }

    @SuppressWarnings("rawtypes")
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        CacheManager cacheManager = RedisCacheManager.create(connectionFactory);
//        return cacheManager;
//
//
//
////        return RedisCacheManager
////                .builder(connectionFactory)
////                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(5)))
////                .transactionAware()
////                .build();
//    }

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


//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
////        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
////        ObjectMapper om = new ObjectMapper();
////        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
////        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
////        jackson2JsonRedisSerializer.setObjectMapper(om);
////        template.setValueSerializer(jackson2JsonRedisSerializer);
////        template.afterPropertiesSet();
//        return template;
//    }

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

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
////        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
////        // 全局开启AutoType，不建议使用
////        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
////        // 建议使用这种方式，小范围指定白名单
////        ParserConfig.getGlobalInstance().addAccept("com.xiaolyuh.");
//
//
//        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new  FastJsonRedisSerializer<>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//        // 设置值（value）的序列化采用FastJsonRedisSerializer。
//        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
//        // 设置键（key）的序列化采用StringRedisSerializer。
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }




}





