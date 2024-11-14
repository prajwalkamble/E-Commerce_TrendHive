package com.deliveryservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryVO {
	private Long deliveryId;
  private Long orderId;
  private String deliveryAddress;
  private Date deliveryDate;
  private String deliveryStatus;
  private String deliveryProvider;
  private String trackingId;
  private String recipientContact;
  private Date estimatedArrival;
  private String confirmationNumber;
  
  public DeliveryVO() {}

	public DeliveryVO(Long deliveryId, Long orderId, String deliveryAddress, Date deliveryDate, String deliveryStatus, String deliveryProvider, String trackingId, String recipientContact, Date estimatedArrival, String confirmationNumber) {
		this.deliveryId = deliveryId;
		this.orderId = orderId;
		this.deliveryAddress = deliveryAddress;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.deliveryProvider = deliveryProvider;
		this.trackingId = trackingId;
		this.recipientContact = recipientContact;
		this.estimatedArrival = estimatedArrival;
		this.confirmationNumber = confirmationNumber;
	}

	@Override
	public String toString() {
		return "DeliveryVO [deliveryId=" + deliveryId 
				+ ", orderId=" + orderId 
				+ ", deliveryAddress=" + deliveryAddress 
				+ ", deliveryDate=" + deliveryDate 
				+ ", deliveryStatus=" + deliveryStatus 
				+ ", deliveryProvider=" + deliveryProvider 
				+ ", trackingId=" + trackingId 
				+ ", recipientContact=" + recipientContact 
				+ ", estimatedArrival=" + estimatedArrival 
				+ ", confirmationNumber=" + confirmationNumber + "]";
	}
}
