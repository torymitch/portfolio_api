package com.api.dto.Checklist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateChecklistDto {
	@NotNull(message = "Rule Is Mandatory")
	@NotBlank(message = "Rule Is Mandatory")
	private String rule;
	
	@NotNull(message = "Question Is Mandatory")
	@NotBlank(message = "Question Is Mandatory")
	private String question;
	
	private String example_1;
	private String example_2;
	private String example_3;
	
	public String getRule() { return rule; }
	public void setRule(String rule) { this.rule = rule; }
	
	public String getQuestion() { return question;}
	public void setQuestion(String question) { this.question = question; }
	
	public String getExample_1() { return example_1;}
	public void setExample_1(String example_1) { this.example_1 = example_1; }
	
	public String getExample_2() { return example_2;}
	public void setExample_2(String example_2) { this.example_2 = example_2; }
	
	public String getExample_3() { return example_3;}
	public void setExample_3(String example_3) { this.example_3 = example_3; }
	
}
