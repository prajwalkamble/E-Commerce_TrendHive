package com.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.productservice.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	// Find product by name
	ProductEntity findByName(String productName);
	
	// Custom query to find a product by name using named parameter
	// Example: ProductRepository.findProductByNameCustom("ProductName")
	@Query(value = "SELECT product FROM ProductEntity product WHERE product.name = :name")
	ProductEntity findProductByNameCustom(@Param("name") String productName);
	
	// Delete product by name
	void deleteByName(String productName);
}
