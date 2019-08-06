package com.app.redis;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

//@RestController
public class CoffeeController {
    private final ReactiveRedisOperations<String, RedisUser> coffeeOps;

    CoffeeController(ReactiveRedisOperations<String, RedisUser> coffeeOps) {
        this.coffeeOps = coffeeOps;
    }

    @GetMapping("/redisuser")
    public Flux<RedisUser> all() {
        return coffeeOps.keys("*")
                .flatMap(coffeeOps.opsForValue()::get);
    }
}