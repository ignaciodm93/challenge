package com.challenge.ms.accreditations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.challenge.ms.accreditations.repository")
@EnableAutoConfiguration(exclude = RedisRepositoriesAutoConfiguration.class)
public class AccreditationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccreditationsApplication.class, args);
	}
}
