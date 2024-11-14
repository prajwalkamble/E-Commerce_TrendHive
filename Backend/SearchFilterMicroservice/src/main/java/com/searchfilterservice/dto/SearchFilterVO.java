package com.searchfilterservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchFilterVO {
	private Long filterId;
  private String filterName;
  private String filterType;  // Type of filter (e.g., "Date", "Category", etc.)
  private String filterValue; // Value applied by this filter (e.g., "2024-11-14" for Date type)
  private Long userId;
  private Date createdAt;
  private Date updatedAt;
  
  public SearchFilterVO() {}

	public SearchFilterVO(Long filterId, String filterName, String filterType, String filterValue, Long userId, Date createdAt, Date updatedAt) {
		this.filterId = filterId;
		this.filterName = filterName;
		this.filterType = filterType;
		this.filterValue = filterValue;
		this.userId = userId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "SearchFilterVO [filterId=" + filterId 
				+ ", filterName=" + filterName 
				+ ", filterType=" + filterType 
				+ ", filterValue=" + filterValue 
				+ ", userId=" + userId 
				+ ", createdAt=" + createdAt 
				+ ", updatedAt=" + updatedAt + "]";
	}
}
