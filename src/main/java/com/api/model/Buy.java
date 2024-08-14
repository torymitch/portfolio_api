package com.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component("buy")
public class Buy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer positionId;
	private Integer accountId;
	private LocalDate date;
	private Float cost;
	private Float shares;
	private Float costPerShare;
	private Float totalCost;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public Integer getPositionId() { return positionId; }
	public void setPositionId(Integer positionId) { this.positionId = positionId; }
	
	public Integer getAccountId() { return accountId; }
	public void setAccountId(Integer accountId) { this.accountId = accountId; 
	
	}
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	
	public Float getCost() { return cost; }
	public void setCost(Float cost) { this.cost = cost; }
	
	public Float getShares() { return shares; }
	public void setShares(Float shares) { this.shares = shares; }
	
	public Float getCostPerShare() { return costPerShare; }
	public void setCostPerShare(Float costPerShare) { this.costPerShare = costPerShare; }
	
	public Float getTotalCost() { return totalCost; }
	public void setTotalCost(Float totalCost) { this.totalCost = totalCost; }
	
	public static long getSerialversionuid() { return serialVersionUID; }
	
	public Buy() {
		super();
		this.setId(null);
		this.setAccountId(null);
		this.setPositionId(null);
		this.setShares(null);
		this.setCost(null);
		this.setCostPerShare(null);
		this.setTotalCost(null);
		this.setDate(null);
	}
	
	public Buy(Integer accountId, Integer positionId, Float shares, 
			Float cost, Float costPerShare, Float totalCost, LocalDate date) {
		super();
		this.setAccountId(accountId);
		this.setPositionId(positionId);
		this.setShares(shares);
		this.setCost(cost);
		this.setCostPerShare(costPerShare);
		this.setTotalCost(totalCost);
		this.setDate(date);
	}
	
	@Override
	public String toString() {
		return "Buy [id=" + id + ", positionId=" + positionId + ", accountId=" + accountId + ", date=" + date
				+ ", cost=" + cost + ", shares=" + shares + ", costPerShare=" + costPerShare + ", totalCost="
				+ totalCost + "]";
	}
	
	
}
