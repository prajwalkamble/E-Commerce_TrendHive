package com.orderservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemVO {
	private Long productId;
	private Integer quantity;
	private BigDecimal price;
	
	public OrderItemVO() {}

	public OrderItemVO(Long productId, Integer quantity, BigDecimal price) {
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
}
