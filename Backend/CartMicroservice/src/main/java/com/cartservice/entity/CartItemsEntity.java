package com.cartservice.entity;

import java.math.BigDecimal;
import java.util.Objects;

import com.productservice.entity.ProductEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartItems")
public class CartItemsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItemId")
	private Long cartItemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartId", nullable = false)
	private CartEntity cart;
	
	@Column(name = "userId")
	private Long userId;
  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	private ProductEntity product;
  
	@Column(name = "quantity")
	private Integer quantity;
  
	@Column(name = "cartItemPrice")
	private BigDecimal cartItemPrice;
	
	public CartItemsEntity() {}

	public CartItemsEntity(Long cartItemId, CartEntity cart, Long userId, ProductEntity product, Integer quantity,
			BigDecimal cartItemPrice) {
		this.cartItemId = cartItemId;
		this.cart = cart;
		this.userId = userId;
		this.product = product;
		this.quantity = quantity;
		this.cartItemPrice = cartItemPrice;
	}
	
	@Override
	public String toString() {
		return "CartItemsEntity [cartItemId=" + cartItemId 
				+ ", cart=" + cart 
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
		CartItemsEntity other = (CartItemsEntity) obj;
		return Objects.equals(cartItemId, other.cartItemId) && Objects.equals(product, other.product);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cartItemId, product);
	}
}
