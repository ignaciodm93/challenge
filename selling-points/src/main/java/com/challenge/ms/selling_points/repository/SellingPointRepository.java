package com.challenge.ms.selling_points.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.challenge.common.models.SellingPoint;

import reactor.core.publisher.Mono;

public interface SellingPointRepository extends ReactiveMongoRepository<SellingPoint, Integer> {
	Mono<SellingPoint> findById(Integer id);
}