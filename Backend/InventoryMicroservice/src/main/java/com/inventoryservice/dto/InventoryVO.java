package com.inventoryservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryVO {
	private Long inventoryId;
	private String productName;
	private String productDescription;
	private Integer quantity;
	private BigDecimal price;
	private String warehouseLocation;
	private String status;
	private String lastUpdated;
	
	public InventoryVO() {}

	public InventoryVO(Long inventoryId, String productName, String productDescription, Integer quantity,
			BigDecimal price, String warehouseLocation, String status, String lastUpdated) {
		this.inventoryId = inventoryId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.price = price;
		this.warehouseLocation = warehouseLocation;
		this.status = status;
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "InventoryVO [inventoryId=" + inventoryId 
				+ ", productName=" + productName 
				+ ", productDescription=" + productDescription 
				+ ", quantity=" + quantity 
				+ ", price=" + price 
				+ ", warehouseLocation=" + warehouseLocation 
				+ ", status=" + status 
				+ ", lastUpdated=" + lastUpdated + "]";
	}
}
