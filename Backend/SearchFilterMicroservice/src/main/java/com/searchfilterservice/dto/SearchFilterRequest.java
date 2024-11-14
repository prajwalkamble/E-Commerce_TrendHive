package com.searchfilterservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchFilterRequest {
	 private String filterName;
   private String filterType;  // Type or category of the filter (e.g., "Text", "Number")
   private String filterValue; // Value to be used in this filter to match search criteria
   private Long userId;
   
   public SearchFilterRequest() {}

   public SearchFilterRequest(String filterName, String filterType, String filterValue, Long userId) {
		this.filterName = filterName;
		this.filterType = filterType;
		this.filterValue = filterValue;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SearchFilterRequest [filterName=" + filterName
				+ ", filterType=" + filterType
				+ ", filterValue=" + filterValue
				+ ", userId=" + userId + "]";
	}
}
