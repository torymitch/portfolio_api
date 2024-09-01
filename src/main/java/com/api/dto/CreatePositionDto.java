package com.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePositionDto {

	@NotNull(message = "Position Name Is Mandatory")
	@NotBlank(message = "Position Name Is Mandatory")
	private String name;
	
	@NotNull(message = "Position Symbol Is Mandatory")
	@NotBlank(message = "Position Symbol Is Mandatory")
	private String symbol;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }

}
