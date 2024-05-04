package com.programmigtechie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmigtechie.demo.dto.ProductRequest;
import com.programmigtechie.demo.dto.ProductResponse;
import com.programmigtechie.demo.model.Product;
import com.programmigtechie.demo.repository.ProductRepository;
import com.programmigtechie.demo.serviceImplemente.ProductImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductImpl {
	@Autowired
	private final ProductRepository productRepository;


	@Override
	public void createProduct(ProductRequest productRequest) {
		Product product =Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		productRepository.save(product);
		log.info("Product {} is created succefully",product.getId());

	}


	@Override
	public List<ProductResponse> getAlllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();


	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

}
