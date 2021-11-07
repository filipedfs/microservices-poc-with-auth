package com.filipefonseca.productservice.repository;

import com.filipefonseca.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
