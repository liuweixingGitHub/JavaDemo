package com.ax.demo.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;


/**
 * Redis缓存配置类
 * @author liuyazhuang
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

//    // 该值是 keyGenerator 方法的方法名称，如果Bean 指定了名称，则使用指定的名称
//    public static final String DEFAULT_KEY_GENERATOR = "keyGenerator";
//
//    // 定义缓存区，缓存区可以在配置时指定不同的过期时间，作为防止缓存雪崩的一个保护措施
//    public static final String COMMON = "COMMON";
//
//
//
//
//    @Autowired
//    private JedisConnectionFactory jedisConnectionFactory;
//
//    /**
//     * @description 自定义的缓存key的生成策略
//     *              若想使用这个key  只需要讲注解上keyGenerator的值设置为keyGenerator即可</br>
//     *               如: @Cacheable(value = "key", keyGenerator = "cacheKeyGenerator")
//     * @return 自定义策略生成的key
//     */
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator(){
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuffer sb = new StringBuffer();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for(Object obj:params){
//                    // 由于参数可能不同, hashCode肯定不一样, 缓存的key也需要不一样
//                    sb.append(JSON.toJSONString(obj).hashCode());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//    //缓存管理器
//    @Bean
//    public RedisCacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
//
//        return RedisCacheManager.create(jedisConnectionFactory);
//    }
//
//    /**
//     * RedisTemplate配置
//     *
//     * @param jedisConnectionFactory
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory ) {
//        //设置序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        //配置redisTemplate
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory);
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);//key序列化
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);//value序列化
//        redisTemplate.setHashKeySerializer(stringSerializer);//Hash key序列化
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);//Hash value序列化
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
}





