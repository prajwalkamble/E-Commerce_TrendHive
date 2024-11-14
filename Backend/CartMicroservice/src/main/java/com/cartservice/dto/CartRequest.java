package com.cartservice.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
	private Long userId;
	private List<CartItemsRequest> CartItemsRequest;
	
	private CartRequest() {}
	
	private CartRequest(Long userId, List<CartItemsRequest> CartItemsRequest) {
		this.userId = userId;
		this.CartItemsRequest = CartItemsRequest;
	}
}
