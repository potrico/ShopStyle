package com.ms.catalog.repository;

import com.ms.catalog.entity.Variations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VariationsRepository extends MongoRepository<Variations, String> {
}
