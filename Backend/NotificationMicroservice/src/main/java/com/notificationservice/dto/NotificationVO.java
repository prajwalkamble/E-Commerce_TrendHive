package com.notificationservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationVO {
	private Long notificationId;
  private Long userId;
  private String notificationType; // Type of the notification (e.g., EMAIL, SMS, PUSH)
  private String messageContent;
  private Date createdAt;
  private String status; // Status of the notification (e.g., SENT, PENDING, FAILED)
  private String priority; // Priority level of the notification (e.g., HIGH, MEDIUM, LOW)
  
  public NotificationVO() {}

	public NotificationVO(Long notificationId, Long userId, String notificationType, String messageContent, Date createdAt, String status, String priority) {
		this.notificationId = notificationId;
		this.userId = userId;
		this.notificationType = notificationType;
		this.messageContent = messageContent;
		this.createdAt = createdAt;
		this.status = status;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "NotificationVO [notificationId=" + notificationId 
				+ ", userId=" + userId 
				+ ", notificationType=" + notificationType 
				+ ", messageContent=" + messageContent 
				+ ", createdAt=" + createdAt 
				+ ", status=" + status 
				+ ", priority=" + priority + "]";
	}
}
