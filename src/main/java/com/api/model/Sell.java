package com.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component("sell")
public class Sell implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer positionId;
	private Integer accountId;
	private LocalDate date;
	private Float soldPrice;
	private Float shares;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public Integer getPositionId() { return positionId; }
	public void setPositionId(Integer positionId) { this.positionId = positionId; }
	
	public Integer getAccountId() { return accountId; }
	public void setAccountId(Integer accountId) { this.accountId = accountId; 
	
	}
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	
	public Float getSoldPrice() { return soldPrice; }
	public void setSoldPrice(Float soldPrice) { this.soldPrice = soldPrice; }
	
	public Float getShares() { return shares; }
	public void setShares(Float shares) { this.shares = shares; }
			
	public static long getSerialversionuid() { return serialVersionUID; }
	
	public Sell() {
		super();
		this.setId(null);
		this.setAccountId(null);
		this.setPositionId(null);
		this.setShares(null);
		this.setSoldPrice(null);
		this.setDate(null);
	}
		
	@Override
	public String toString() {
		return "Sell [id=" + id + ", positionId=" + positionId + ", accountId=" + accountId + ", date=" + date
				+ ", soldPrice=" + soldPrice + ", shares=" + shares + "]";
	}
	
	
}
