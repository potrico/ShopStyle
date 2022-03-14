package com.ms.catalog.repository;

import com.ms.catalog.entity.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriesRepository extends MongoRepository<Categories, String> {
}
