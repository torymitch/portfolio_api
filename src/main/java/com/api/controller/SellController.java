package com.api.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Buy;
import com.api.model.Sell;
import com.api.service.SellSvc;

@CrossOrigin
@RestController
public class SellController {
	
	@Autowired
	private SellSvc sellSvc;

	@CrossOrigin
	@PostMapping("/addSell")
	public ResponseEntity<Object> addSell(@RequestBody Sell sell) {
		try {
			Sell newSell = sellSvc.addSell(sell);
			if (!ObjectUtils.isEmpty(newSell)) {
				return (ResponseEntity.ok(newSell));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sell Record Creation Failed");
	}
}
