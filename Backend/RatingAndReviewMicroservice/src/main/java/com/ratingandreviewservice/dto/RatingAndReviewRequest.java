package com.ratingandreviewservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingAndReviewRequest {
	private Long userId;
  private Long productId;
  private Integer rating;
  private String reviewText;
  
  public RatingAndReviewRequest() {}

	public RatingAndReviewRequest(Long userId, Long productId, Integer rating, String reviewText) {
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.reviewText = reviewText;
	}

	@Override
	public String toString() {
		return "RatingAndReviewRequest [userId=" + userId
				+ ", productId=" + productId
				+ ", rating=" + rating
				+ ", reviewText=" + reviewText + "]";
	}
}
