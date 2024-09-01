package com.api.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdatePositionDto {
	
	@NotNull(message = "Position Id Is Mandatory")
	private Integer id;
	
	@NotNull(message = "Position Name Is Mandatory")
	@NotBlank(message = "Position Name Is Mandatory")
	private String name;
	
	@NotNull(message = "Position Symbol Is Mandatory")
	@NotBlank(message = "Position Symbol Is Mandatory")
	private String symbol;
	
	@Range(min = (long) .001 , message = "Value cannot be less than .001")
	private Float price;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }
	
	public Float getPrice() { return price; }
	public void setPrice(Float price) { this.price = price; }
	

}
