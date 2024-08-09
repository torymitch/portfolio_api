package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Position;
import com.api.model.User;
import com.api.service.PositionSvc;

@CrossOrigin
@RestController
public class PositionController {
	
	@Autowired
	private PositionSvc positionSvc;
	
	@PostMapping("/addPosition")
	public Position addPosition(
			@RequestBody Position position,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "symbol") String symbol
			) {
		position = new Position(name, symbol);
		return positionSvc.addPosition(position);
	}
	
	@GetMapping("/getPositions")
	public Iterable<Position> getPositions() {
		System.out.print("Retrieve All Positions");
		return positionSvc.getPositions();
	}
}