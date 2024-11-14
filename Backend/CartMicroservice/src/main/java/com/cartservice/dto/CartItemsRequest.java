package com.cartservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemsRequest {
	private Long productId;
	private Integer quantity;
	private BigDecimal cartItemPrice;
	
	private CartItemsRequest() {}
	
	private CartItemsRequest(Long productId, Integer quantity, BigDecimal cartItemPrice) {
		this.productId = productId;
		this.quantity = quantity;
		this.cartItemPrice = cartItemPrice;
	}
}
