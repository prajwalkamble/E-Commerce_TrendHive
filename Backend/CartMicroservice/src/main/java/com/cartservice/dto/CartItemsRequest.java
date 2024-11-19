package com.cartservice.dto;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemsRequest {
	private Long cartId;
	private Long userId;
	private Long productId;
	private Integer quantity;
	private BigDecimal cartItemPrice;
	
	public CartItemsRequest() {}

	public CartItemsRequest(Long cartId, Long userId, Long productId, Integer quantity, BigDecimal cartItemPrice) {
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.cartItemPrice = cartItemPrice;
	}

	@Override
	public String toString() {
		return "CartItemsRequest [cartId=" + cartId 
				+ ", userId=" + userId
				+ ", productId=" + productId 
				+ ", quantity=" + quantity 
				+ ", cartItemPrice=" + cartItemPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CartItemsRequest other = (CartItemsRequest) obj;
		return Objects.equals(cartId, other.cartId) && Objects.equals(productId, other.productId);
	}
}
