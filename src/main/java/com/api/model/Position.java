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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Position() {
		super();
		this.name = "";
		this.symbol = "";
		this.cost = 0f;
		this.price = 0f;
		this.total = 0f;
		
	}
	
	public Position(String name, String symbol) {
		super();
		this.setName(name);
		this.setSymbol(symbol);
	}
	
	public Position(String name, String symbol, Float price, Float coast, Float total) {
		super();
		this.setName(name);
		this.setSymbol(symbol);
		this.setName(name);
		this.setPrice(price);
		this.setTotal(total);
	}
	
	public Position(Integer id, String name, String symbol, Float price, Float coast, Float total) {
		super();
		this.setId(id);
		this.setName(name);
		this.setSymbol(symbol);
		this.setName(name);
		this.setPrice(price);
		this.setTotal(total);
	}
	
	public Position(Position position) {
		super();
		this.id = position.id;
		this.name = position.name;
		this.symbol = position.symbol;
		this.cost = position.cost;
		this.price = position.price;
		this.total = position.total;
	}
	
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", symbol=" + symbol + ", cost=" + cost + ", price=" + price + ", total=" + total
				+ "]";
	}

	
	 
}
