package com.api.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component("Checklist")
public class Checklist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	private String rule;
	private String question;
	private String example_1;
	private String example_2;
	private String example_3;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getRule() { return rule; }
	public void setRule(String rule) { this.rule = rule; }
	
	public String getQuestion() { return question; }
	public void setQuestion(String question) { this.question = question; }
	
	public String getExample_1() { return example_1; }
	public void setExample_1(String example_1) { this.example_1 = example_1; }
	
	public String getExample_2() { return example_2; }
	public void setExample_2(String example_2) { this.example_2 = example_2; }
	
	public String getExample_3() { return example_3; }
	public void setExample_3(String example_3) { this.example_3 = example_3; }
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Checklist() {
		super();
		this.id = null;
		this.rule = "";
		this.question = "";
		this.example_1 = "";
		this.example_2 = "";
		this.example_3 = "";
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", rule=" + rule + ", question=" + question + ", example_1=" + example_1 + ", example_2=" + example_2 + ", example_3=" + example_3 + "]";
	}	 
}
