package com.app.redis;

import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;
import com.app.redis.RedisUser;

//@Component
public class CoffeeLoader {
	private final ReactiveRedisConnectionFactory factory;
	private final ReactiveRedisOperations<String, RedisUser> coffeeOps;

	public CoffeeLoader(ReactiveRedisConnectionFactory factory, ReactiveRedisOperations<String, RedisUser> coffeeOps) {
		this.factory = factory;
		this.coffeeOps = coffeeOps;
	}

	@PostConstruct
	public void loadData() {
		factory.getReactiveConnection().serverCommands().flushAll()

				.thenMany(Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
						.map(name -> new RedisUser(UUID.randomUUID().toString(), name))
						.flatMap(coffee -> coffeeOps.opsForValue().set(coffee.getPassword(), coffee)))

				.thenMany(coffeeOps.keys("*").flatMap(coffeeOps.opsForValue()::get)).subscribe(System.out::println);
	}
}