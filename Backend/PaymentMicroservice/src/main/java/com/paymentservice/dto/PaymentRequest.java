package com.paymentservice.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
	private Long orderId;
  private BigDecimal amount;
  private String paymentMethod;
  private String cardNumber;  // For card payments
  private String cardExpiry;  // For card payments
  private String cardCvv;     // For card payments
  
  public PaymentRequest() {}

	public PaymentRequest(Long orderId, BigDecimal amount, String paymentMethod, String cardNumber, String cardExpiry, String cardCvv) {
		this.orderId = orderId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardCvv = cardCvv;
	}

	@Override
	public String toString() {
		return "PaymentRequest [orderId=" + orderId 
					+ ", amount=" + amount 
					+ ", paymentMethod=" + paymentMethod 
					+ ", cardNumber=" + cardNumber 
					+ ", cardExpiry=" + cardExpiry 
					+ ", cardCvv=" + cardCvv + "]";
	}
}
