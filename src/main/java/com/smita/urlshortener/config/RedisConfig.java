package com.smita.urlshortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
// Tells Spring how certain objects (beans) should be created and configured.
public class RedisConfig {

    @Bean

    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) { // redisTemplate is not a data structure, it's an access layer to talk to redis.

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // important: avoid binary junk in Redis
        // redis stores in bytes not objects, spring converts it into bytes using serializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }
}

