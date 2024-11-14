package com.ratingandreviewservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingAndReviewVO {
	private Long reviewId;
  private Long userId;
  private Long productId;
  private Integer rating; // Rating score given by the user, usually on a scale (e.g., 1 to 5).
  private String reviewText;
  private Date createdAt;
  private Date updatedAt;
  
  public RatingAndReviewVO() {}

	public RatingAndReviewVO(Long reviewId, Long userId, Long productId, Integer rating, String reviewText, Date createdAt, Date updatedAt) {
		this.reviewId = reviewId;
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "RatingAndReviewVO [reviewId=" + reviewId 
				+ ", userId=" + userId
				+ ", productId=" + productId
				+ ", rating=" + rating
				+ ", reviewText=" + reviewText
				+ ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
