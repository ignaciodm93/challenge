package com.challenge.ms.selling_costs.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.challenge.common.models.SellingCost;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SellingCostRepository extends ReactiveMongoRepository<SellingCost, String> {

	Mono<Void> deleteByStartingPointAndEndingPoint(Integer startingPoint, Integer endingPoint);

	Mono<SellingCost> findByStartingPointAndEndingPoint(Integer startingPoint, Integer endingPoint);

	Flux<SellingCost> findByStartingPoint(Integer startingPoint);

}