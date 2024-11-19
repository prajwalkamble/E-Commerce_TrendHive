package com.productservice.service;

import java.util.List;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductVO;
import com.productservice.exception.ProductExceptionCustom;

public interface ProductServiceInterface {
	// Fetch all Products
	List<ProductVO> findAll();
	
	// Find product by ID
	ProductVO findById(Long productId) throws ProductExceptionCustom;
	
	// Create or update a product
	ProductVO save(ProductRequest productRequest) throws ProductExceptionCustom;
	
	// Delete a product by ID
	String delete(Long productId) throws ProductExceptionCustom;
	
	// Find product by name
	ProductVO findByName(String productName) throws ProductExceptionCustom;
	
	// Find product by name using custom method
	ProductVO findProductByName(String productName) throws ProductExceptionCustom;
	
	// Delete product by name
	void deleteProductByName(String productName) throws ProductExceptionCustom;

	ProductVO update(Long productId, ProductRequest productRequest) throws ProductExceptionCustom;
}
