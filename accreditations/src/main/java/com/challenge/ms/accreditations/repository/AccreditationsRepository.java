package com.challenge.ms.accreditations.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.challenge.common.models.AccreditationDocument;

import reactor.core.publisher.Mono;

@Repository
public interface AccreditationsRepository extends ReactiveMongoRepository<AccreditationDocument, String> {

	Mono<AccreditationDocument> findBySellingPointId(Integer accreditationSellingPointId);

}