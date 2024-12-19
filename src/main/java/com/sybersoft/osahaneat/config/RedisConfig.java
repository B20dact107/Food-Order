package com.sybersoft.osahaneat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory redisConnection(){
        RedisStandaloneConfiguration configuration= new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6380);
//        configuration.setDatabase(0);
//        configuration.setUsername("");
//        configuration.setPassword("");
        return new LettuceConnectionFactory(configuration);
    }
    @Bean
    RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory redisLettuceConnectionFactory){
        RedisTemplate<String,Object> template= new RedisTemplate<>();
        template.setConnectionFactory(redisLettuceConnectionFactory);
        return template;
    }
}
