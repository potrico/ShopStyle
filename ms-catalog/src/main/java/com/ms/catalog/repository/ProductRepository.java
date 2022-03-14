package com.ms.catalog.repository;

import com.ms.catalog.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String> {
}
