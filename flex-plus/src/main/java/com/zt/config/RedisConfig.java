package com.zt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-09  11:43
 * @Description: redis 工具类
 * @Version: 1.0
 */
@Configuration
public class RedisConfig {
    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        System.out.println("redis序列化-->");
        RedisTemplate redisTemplate = new RedisTemplate();
        RedisSerializer redisSerializer = new StringRedisSerializer();
        //连接工厂
        redisTemplate.setConnectionFactory(factory);
        //键序列化
        redisTemplate.setKeySerializer(redisSerializer);
        //值序列化
        redisTemplate.setValueSerializer(redisSerializer);
        //key hashMap序列化
        redisTemplate.setHashKeySerializer(redisSerializer);
        //value hashMap序列化
        redisTemplate.setHashValueSerializer(redisSerializer);
        return redisTemplate;
    }
}
