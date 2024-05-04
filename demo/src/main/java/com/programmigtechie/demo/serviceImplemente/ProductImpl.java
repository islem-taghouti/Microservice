package com.programmigtechie.demo.serviceImplemente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmigtechie.demo.dto.ProductRequest;
import com.programmigtechie.demo.dto.ProductResponse;
@Service
public interface ProductImpl {
	public void createProduct(ProductRequest productRequest);

	public List<ProductResponse> getAlllProducts();
}