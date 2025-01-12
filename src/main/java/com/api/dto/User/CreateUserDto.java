package com.api.dto.User;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class CreateUserDto {
	
	@NotNull(message = "First Name Is Mandatory")
//	@Getter @Setter 
	private String firstName;
	
	@NotNull(message = "Last Name Is Mandatory")
//	@Getter @Setter 
	private String lastName;
	
	@NotNull(message = "User Name Is Mandatory")
//	@Getter @Setter 
	private String userName;
	
	@NotNull(message = "Phone Number Is Mandatory")
	@Pattern(regexp="(^$|[0-9]{10})")
	@Getter @Setter 
	private String phoneNumber;
	
	@Email(message = "Email Is Mandatory")
//	@Getter @Setter 
	private String emailAddress;
	
	public String firstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String lastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String userName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }

	public String phoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	
	public String emailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
	
}
