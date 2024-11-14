package com.paymentservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentVO {
	private Long paymentId;
  private Long orderId;
  private BigDecimal amount;
  private String paymentStatus;
  private String paymentMethod;
  private String transactionId;
  private Date paymentDate;
  private String confirmationNumber;
  
  public PaymentVO() {}

	public PaymentVO(Long paymentId, Long orderId, BigDecimal amount, String paymentStatus, String paymentMethod, String transactionId, Date paymentDate, String confirmationNumber) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.paymentDate = paymentDate;
		this.confirmationNumber = confirmationNumber;
	}

	@Override
	public String toString() {
		return "PaymentVO [paymentId=" + paymentId 
					+ ", orderId=" + orderId 
					+ ", amount=" + amount 
					+ ", paymentStatus=" + paymentStatus 
					+ ", paymentMethod=" + paymentMethod 
					+ ", transactionId=" + transactionId 
					+ ", paymentDate=" + paymentDate 
					+ ", confirmationNumber=" + confirmationNumber + "]";
	}
}
