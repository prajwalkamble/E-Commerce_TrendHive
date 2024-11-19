package com.productservice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "productName", nullable = false)
	private String productName;
	
	@Column(name = "productDescription")
	private String productDescription;
	
	@Column(name = "productPrice", nullable = false)
	private Double productPrice;
	
	@Column(name = "productCategory")
	private String productCategory; 
	
	@Column(name = "productBrand")
	private String productBrand;
	
	@Column(name = "productSKU")
	private String productSKU;
	
	@Column(name = "productStatus")
	private String productStatus; // active, discontinued or out of stock
	
	@Column(name = "productCreatedAt", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date productCreatedAt;
	
	@Column(name = "productUpdatedAt", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date productUpdatedAt;
	
	public ProductEntity() {}

	public ProductEntity(Long productId, String productName, String productDescription, Double productPrice, String productCategory, String productBrand, String productSKU, String productStatus, Date productCreatedAt, Date productUpdatedAt) {
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

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId 
				+ ", productName=" + productName 
				+ ", productDescription=" + productDescription 
				+ ", productPrice=" + productPrice 
				+ ", productCategory=" + productCategory 
				+ ", productBrand=" + productBrand 
				+ ", productSKU=" + productSKU 
				+ ", productStatus=" + productStatus 
				+ ", productCreatedAt=" + productCreatedAt 
				+ ", productUpdatedAt=" + productUpdatedAt + "]";
	}
}
