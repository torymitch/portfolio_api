package com.api.model;

import org.springframework.stereotype.Component;

//import jakarta.persistence.Entity;

//@Entity
@Component("test")
public class Test {

	private String first_name;
	private String last_name;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@Override
	public String toString() {
		return "Test [first_name=" + first_name + ", last_name=" + last_name + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
