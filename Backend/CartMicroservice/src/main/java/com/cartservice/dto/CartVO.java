package com.cartservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
	private Long cartId;
	private Integer totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	private Date createdDate;
  private Date updatedDate;
  private List<CartItemsVO> cartItemsVO;
  
  public CartVO() {}
  
  public CartVO(Long cartId, Integer totalQuantity, BigDecimal totalPrice, String status, Date createdDate, Date updatedDate, List<CartItemsVO> cartItemsVO) {
  	this.cartId = cartId;
  	this.totalQuantity = totalQuantity;
  	this.totalPrice = totalPrice;
  	this.status = status;
  	this.createdDate = createdDate;
  	this.updatedDate = updatedDate;
  	this.cartItemsVO = cartItemsVO;
  }

	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId 
				+ ", totalQuantity=" + totalQuantity 
				+ ", totalPrice=" + totalPrice 
				+ ", status=" + status 
				+ ", createdDate=" + createdDate 
				+ ", updatedDate=" + updatedDate 
				+ ", cartItemsVO=" + cartItemsVO + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CartVO other = (CartVO) obj;
		return Objects.equals(cartId, other.cartId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cartId);
	}
}
