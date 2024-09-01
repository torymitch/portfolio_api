package com.api.model;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component("Account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	private String name;
	private String number;
	private Integer user_id;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	
	public Integer getUserId() { return user_id; }
	public void setUserId(Integer user_id) { this.user_id = user_id; }
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Account() {
		super();
		this.id = null;
		this.name = "";
		this.number = "";
		this.user_id = null;
		
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", number=" + number + ", user_id=" + user_id+"]";
	}
	
	
		
	 
}
