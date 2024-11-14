package com.orderservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVO {
	private Long orderId;
  private Long userId;
  private String orderStatus;
  private BigDecimal totalAmount;
  private String paymentMethod;
  private Date orderDate;
  private Date deliveryDate;
  private String deliveryAddress;
  private List<OrderItemVO> orderItemsVO;
  
  public OrderVO() {}

	public OrderVO(Long orderId, Long userId, String orderStatus, BigDecimal totalAmount, String paymentMethod, Date orderDate, Date deliveryDate, String deliveryAddress, List<OrderItemVO> orderItemsVO) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.deliveryAddress = deliveryAddress;
		this.orderItemsVO = orderItemsVO;
	}
}
