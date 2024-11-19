package com.cartservice.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.cartservice.dto.CartItemsVO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	private Long cartId;
	
	@Column(name = "totalQuantity", nullable = false)
	private Integer totalQuantity;
	
	@Column(name = "totalPrice", nullable = false)
	private BigDecimal totalPrice;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "createdDate", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
  
	@Column(name = "updatedDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
  
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItemsVO> cartItemsVO;
	
	public CartEntity() {}

	public CartEntity(Long cartId, Integer totalQuantity, BigDecimal totalPrice, String status, Date createdDate, Date updatedDate, List<CartItemsVO> cartItemsVO) {
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
		return "CartEntity [cartId=" + cartId 
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
		CartEntity other = (CartEntity) obj;
		return Objects.equals(cartId, other.cartId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cartId);
	}
}
