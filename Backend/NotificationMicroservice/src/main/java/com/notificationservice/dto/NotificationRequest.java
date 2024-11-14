package com.notificationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
	private Long userId;
  private String notificationType;
  private String messageContent;
  private String priority;
  
  public NotificationRequest() {}

	public NotificationRequest(Long userId, String notificationType, String messageContent, String priority) {
		this.userId = userId;
		this.notificationType = notificationType;
		this.messageContent = messageContent;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "NotificationRequest [userId=" + userId 
				+ ", notificationType=" + notificationType 
				+ ", messageContent=" + messageContent 
				+ ", priority=" + priority + "]";
	}
}
