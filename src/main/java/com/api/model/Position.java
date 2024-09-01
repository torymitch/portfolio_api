package com.api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component("position")
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String symbol;
	private Float cost;
	private Float price;
	private Float total;
	private Float shares;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }
	
	public Float getCost() { return cost; }
	public void setCost(Float cost) { this.cost = cost; }
	
	public Float getPrice() { return price; }
	public void setPrice(Float price) { this.price = price; }
	
	public Float getTotal() { return total; }
	public void setTotal(Float total) { this.total = total; }
	
	public Float getShares() { return shares; }
	public void setShares(Float shares) { this.shares = shares; }
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Position() {
		super();
		this.name = "";
		this.symbol = "";
		this.shares = 0f;
		this.cost = 0f;
		this.price = 0f;
		this.total = 0f;
		
	}
	
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", symbol=" + symbol + ", cost=" + cost + ", price=" + price + ", total=" + total
				+ "]";
	}

	
	 
}
