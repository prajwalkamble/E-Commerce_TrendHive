package com.cartservice.dto;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
	private Long cartId;
	private Integer totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	
	public CartRequest() {}

	public CartRequest(Long cartId, Integer totalQuantity, BigDecimal totalPrice, String status) {
		this.cartId = cartId;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	@Override
	public String toString() {
		return "CartRequest [cartId=" + cartId 
				+ ", totalQuantity=" + totalQuantity 
				+ ", totalPrice=" + totalPrice 
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CartRequest other = (CartRequest) obj;
		return Objects.equals(cartId, other.cartId);
	}
}
