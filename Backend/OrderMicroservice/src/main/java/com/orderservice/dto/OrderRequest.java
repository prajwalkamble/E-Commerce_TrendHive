package com.orderservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
	private Long userId;
	private String paymentMethod;
	private BigDecimal totalAmount;
	private String deliveryAddress;
	private List<OrderItemRequest> orderItemRequest;
	
	public OrderRequest() {}

	public OrderRequest(Long userId, String paymentMethod, BigDecimal totalAmount, String deliveryAddress, List<OrderItemRequest> orderItemRequest) {
		super();
		this.userId = userId;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.deliveryAddress = deliveryAddress;
		this.orderItemRequest = orderItemRequest;
	}
}
