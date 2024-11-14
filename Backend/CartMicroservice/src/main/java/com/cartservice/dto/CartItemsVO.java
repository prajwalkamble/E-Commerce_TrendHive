package com.cartservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemsVO {
	private Long cartItemId;
  private Long productId;
  private Integer quantity;
  private BigDecimal cartItemPrice;
  
  public CartItemsVO() {}
  
  public CartItemsVO(Long cartItemId, Long productId, Integer quantity, BigDecimal cartItemPrice) {
  	this.cartItemId = cartItemId;
  	this.productId = productId;
  	this.quantity = quantity;
  	this.cartItemPrice = cartItemPrice;
  }
}
