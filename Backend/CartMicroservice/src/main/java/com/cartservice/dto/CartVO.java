package com.cartservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
	private Long cartId;
	private Long userId;
	private Integer totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	private Date createdDate;
  private Date updatedDate;
  private List<CartItemsVO> cartItemsVO;
  
  public CartVO() {}
  
  public CartVO(Long cartId, Long userId, Integer totalQuantity, BigDecimal totalPrice, String status, Date createdDate, Date updatedDate, List<CartItemsVO> cartItemsVO) {
  	this.cartId = cartId;
  	this.userId = userId;
  	this.totalQuantity = totalQuantity;
  	this.totalPrice = totalPrice;
  	this.status = status;
  	this.createdDate = createdDate;
  	this.updatedDate = updatedDate;
  	this.cartItemsVO = cartItemsVO;
  }
}
