package com.app.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Configuration
public class CoffeeConfiguration {
    @Bean
    ReactiveRedisOperations<String, RedisUser> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<RedisUser> serializer = new Jackson2JsonRedisSerializer<>(RedisUser.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, RedisUser> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, RedisUser> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

}