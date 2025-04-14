package com.challenge.ms.selling_points;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.challenge.common.config", "com.challenge.common.jwt",
		"com.challenge.common.config", "com.challenge.ms.selling_points" })
@EnableReactiveMongoRepositories(basePackages = { "com.challenge.ms.selling_points.repository",
		"com.challenge.common.repository" })
@EnableAutoConfiguration(exclude = RedisRepositoriesAutoConfiguration.class)
public class SellingPointsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellingPointsApplication.class, args);
	}
}
