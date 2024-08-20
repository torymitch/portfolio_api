package com.api.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component("accountPosition")
public class AccountPosition implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer accountId;
	private Integer positionId;
	private String accountName;
	private String accountNumber;
	private String positionName;
	private String positionSymbol;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public Integer getAccountId() { return accountId; }
	public void setAccountId(Integer accountId) { this.accountId = accountId; }
	
	public Integer getPositionId() { return positionId; }
	public void setPositionId(Integer positionId) { this.positionId = positionId; }
	
	public String getAccountName() { return accountName; }
	public void setAccountName(String accountName) { this.accountName = accountName; }
	
	public String getAccountNumber() { return accountNumber; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
	
	public String getPositionName() { return positionName; }
	public void setPositionName(String positionName) { this.positionName = positionName; }
	
	public String getPositionSymbol() { return positionSymbol; }
	public void setPositionSymbol(String positionSymbol) { this.positionSymbol = positionSymbol; }	
}
