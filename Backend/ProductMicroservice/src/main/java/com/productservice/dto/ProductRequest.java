package com.productservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
	private Long productId;
	private String productName;
	private String productDescription;
	private Double productPrice;
	private String productCategory; 
	private String productBrand;
	private String productSKU;
	private String productStatus; // active, discontinued or out of stock
	private Date productCreatedAt;
	private Date productUpdatedAt;
	
	public ProductRequest() {}

	public ProductRequest(Long productId, String productName, String productDescription, Double productPrice, String productCategory, String productBrand, String productSKU, String productStatus, Date productCreatedAt, Date productUpdatedAt) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.productSKU = productSKU;
		this.productStatus = productStatus;
		this.productCreatedAt = productCreatedAt;
		this.productUpdatedAt = productUpdatedAt;
	}
}
