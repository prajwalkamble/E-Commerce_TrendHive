package com.deliveryservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequest {
	private Long orderId;
  private String deliveryAddress;
  private String deliveryProvider;
  private String recipientContact;
  private Date estimatedArrival;
  
  public DeliveryRequest() {}

	public DeliveryRequest(Long orderId, String deliveryAddress, String deliveryProvider, String recipientContact, Date estimatedArrival) {
		this.orderId = orderId;
		this.deliveryAddress = deliveryAddress;
		this.deliveryProvider = deliveryProvider;
		this.recipientContact = recipientContact;
		this.estimatedArrival = estimatedArrival;
	}

	@Override
	public String toString() {
		return "DeliveryRequest [orderId=" + orderId 
				+ ", deliveryAddress=" + deliveryAddress 
				+ ", deliveryProvider=" + deliveryProvider 
				+ ", recipientContact=" + recipientContact 
				+ ", estimatedArrival=" + estimatedArrival + "]";
	}
}
