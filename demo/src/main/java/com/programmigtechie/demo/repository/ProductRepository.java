package com.programmigtechie.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programmigtechie.demo.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
