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
	private Integer position_id;
	private Integer account_id;
	private LocalDate date;
	private Float cost;
	private Float shares;
	private Float cost_per_share;
	private Float total_cost;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public Integer getPositionId() { return position_id; }
	public void setPositionId(Integer position_id) { this.position_id = position_id; }
	
	public Integer getAccountId() { return account_id; }
	public void setAccountId(Integer account_id) { this.account_id = account_id; 
	
	}
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	
	public Float getCost() { return cost; }
	public void setCost(Float cost) { this.cost = cost; }
	
	public Float getShares() { return shares; }
	public void setShares(Float shares) { this.shares = shares; }
	
	public Float getCostPerShare() { return cost_per_share; }
	public void setCostPerShare(Float cost_per_share) { this.cost_per_share = cost_per_share; }
	
	public Float getTotalCost() { return total_cost; }
	public void setTotalCost(Float total_cost) { this.total_cost = total_cost; }
	
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
	
	public Buy(Integer account_id, Integer position_id, Float shares, 
			Float cost, Float cost_per_share, Float total_cost, LocalDate date) {
		super();
		this.setAccountId(account_id);
		this.setPositionId(position_id);
		this.setShares(shares);
		this.setCost(cost);
		this.setCostPerShare(cost_per_share);
		this.setTotalCost(total_cost);
		this.setDate(date);
	}
	
	@Override
	public String toString() {
		return "Buy [position_id=" + position_id + ", account_id=" + account_id + ", date=" + date + ", cost=" + cost
				+ ", shares=" + shares + ", cost_per_share=" + cost_per_share + ", total_cost=" + total_cost + "]";
	}
	
	
	
}
