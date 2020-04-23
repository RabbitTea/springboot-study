package com.sandra.springbootredis.config;

import java.net.UnknownHostException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.sandra.springbootredis.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *
 */
@Configuration
public class RedisConfig {

    /**
     * 编写自己的redisTemplate
     */
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
        throws UnknownHostException {

        // 一般为了开发方便，直接使用<String, Object>
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 配置具体的序列化方式
        // Jackson的序列化
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // 进行转义
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
        om.enableDefaultTyping(DefaultTyping.NON_FINAL);
        objectJackson2JsonRedisSerializer.setObjectMapper(om);
        // string的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);

        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);

        // value序列化方式采用Jackson
        template.setValueSerializer(objectJackson2JsonRedisSerializer);

        // hash的value序列化方式采用Jackson
        template.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
