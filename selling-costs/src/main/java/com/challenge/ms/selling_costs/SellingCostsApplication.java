package com.challenge.ms.selling_costs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.challenge.common.config", "com.challenge.common.jwt",
		"com.challenge.common.config", "com.challenge.ms.selling_costs" })
@EnableReactiveMongoRepositories(basePackages = { "com.challenge.ms.selling_costs.repository",
		"com.challenge.common.repository" })
@EnableAutoConfiguration(exclude = RedisRepositoriesAutoConfiguration.class)
public class SellingCostsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellingCostsApplication.class, args);
	}
}
