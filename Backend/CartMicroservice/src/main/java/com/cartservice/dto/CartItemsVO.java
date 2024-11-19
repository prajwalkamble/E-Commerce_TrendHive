package com.cartservice.dto;

import java.math.BigDecimal;
import java.util.Objects;

import com.productservice.dto.ProductVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemsVO {
	private Long cartItemId;
	private Long cartId;
	private Long userId;
  private ProductVO product;
  private Integer quantity;
  private BigDecimal cartItemPrice;
  
  public CartItemsVO() {}

	public CartItemsVO(Long cartItemId, Long cartId, Long userId, Integer quantity, BigDecimal cartItemPrice, ProductVO product) {
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.userId = userId;
		this.product = product;
		this.quantity = quantity;
		this.cartItemPrice = cartItemPrice;
	}

	@Override
	public String toString() {
		return "CartItemsVO [cartItemId=" + cartItemId 
				+ ", cartId=" + cartId 
				+ ", userId=" + userId 
				+ ", product=" + product 
				+ ", quantity=" + quantity 
				+ ", cartItemPrice=" + cartItemPrice + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CartItemsVO other = (CartItemsVO) obj;
		return Objects.equals(cartItemId, other.cartItemId);
	}
  
	@Override
	public int hashCode() {
		return Objects.hash(cartItemId);
	}
}
