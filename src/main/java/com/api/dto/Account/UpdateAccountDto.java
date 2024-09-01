package com.api.dto.Account;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateAccountDto {
	
	@Range(min = 1, message= "Account Id Is Mandatory")
	private Integer id;
	
	@NotNull(message = "Account Name Is Mandatory")
	@NotBlank(message = "Account Name Is Mandatory")
	private String name;
	
	@NotNull(message = "Account Number Is Mandatory")
	@NotBlank(message = "Account Number Is Mandatory")
	private String number;
	
	@Range(min = 1, message= "User Id Is Mandatory")
	@NotNull(message = "User Id Is Mandatory")
	private Integer user_id;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	
	public Integer getUserId() { return user_id; }
	public void setUserId(Integer user_id) { this.user_id = user_id; }
	
}
