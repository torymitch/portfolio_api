package com.api.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component("user")
//public class User {
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	private String first_name;
	private String last_name;
	private String user_name;
	private String phone_number;
	private String email_address;

	
	public String getFirstName() { return first_name; }
	public String getLastName() { return last_name; }
	public String getUserName() { return user_name; }
	public String getPhone() { return phone_number; }
	public String email_address() { return email_address; }
	

	public void setFirstName(String first_name) { this.first_name = first_name; }
	public void setLastName(String last_name) { this.last_name = last_name; }
	public void setUserName(String user_name) { this.user_name = user_name; }
	public void setPhoneNumber(String phone_number) { this.phone_number = phone_number; }
	public void setEmailAddress(String email_address) { this.email_address = email_address; }
  
	public User() {
		super();
		this.first_name = "";
		this.last_name = "";
		this.user_name = "";
		this.phone_number = "";
		this.email_address = "";
		
	}
	
	public User(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}
  
	public User(String first_name, String last_name, String user_name, String phone_number, String email_address) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.phone_number = phone_number;
		this.email_address = email_address;
	}
	
	public User(User user) {
		super();
		this.id = user.id;
		this.first_name = user.first_name;
		this.last_name = user.last_name;
		this.user_name = user.user_name;
		this.phone_number = user.phone_number;
		this.email_address = user.email_address;
	}

    @Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", user_name=" + user_name
				+ ", phone_number=" + phone_number + ", email_address=" + email_address + "]";
	} 
}
