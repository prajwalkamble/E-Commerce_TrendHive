package com.inventoryservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryRequest {
	 private String productName;
   private String productDescription;
   private Integer quantity;
   private BigDecimal price;
   private String warehouseLocation;
   private String status;
   
   public InventoryRequest() {}

	public InventoryRequest(String productName, String productDescription, Integer quantity, BigDecimal price, String warehouseLocation, String status) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.price = price;
		this.warehouseLocation = warehouseLocation;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "InventoryVO [productName=" + productName 
				+ ", productDescription=" + productDescription 
				+ ", quantity=" + quantity 
				+ ", price=" + price 
				+ ", warehouseLocation=" + warehouseLocation 
				+ ", status=" + status + "]";
	}
}
