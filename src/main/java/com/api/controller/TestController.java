package com.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Test;

@CrossOrigin
@RestController
public class TestController {
	
//	@Autowired 
//	private Test test;
	
	@PostMapping("/addTest")
	public Test addTest(@RequestBody Test test) {
		System.out.println("Add The Test " + test);
		return test;
	}
}