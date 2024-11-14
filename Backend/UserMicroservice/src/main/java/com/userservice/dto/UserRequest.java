package com.userservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	private Long userId;
	private String username;
  private String email;
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private String phoneNumber;
  private String address;
  
  public UserRequest() {}

	public UserRequest(Long userId, String username, String email, String firstName, String lastName, Date dateOfBirth, String phoneNumber, String address) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserRequest [userId=" + userId 
				+ ", email=" + email 
				+ ", firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", dateOfBirth=" + dateOfBirth 
				+ ", phoneNumber=" + phoneNumber 
				+ ", address=" + address 
				+"]";
	}
}
