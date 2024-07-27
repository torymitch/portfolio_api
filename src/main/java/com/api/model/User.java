package com.api.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Component("user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String userName;
	private String phone;

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getUserName() { return userName; }
	public String getPhone() { return phone; }
	

	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setUserName(String userName) { this.userName = userName; }
	public void setPhone(String phone) { this.phone = phone; }
  
	public User() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.userName = "";
		this.phone = "";
	}
  
	public User(String firstName, String lastName, String userName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.phone = phone;
	}
	
	public User(User user) {
		super();
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.userName = user.userName;
		this.phone = user.phone;
	}

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + userName + " " + phone;
    } 
}
