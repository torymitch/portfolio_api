package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Position;
import com.api.service.PositionSvc;

@CrossOrigin
@RestController
public class PositionController {
	
	@Autowired
	private PositionSvc positionSvc;
	
	@GetMapping("/getPositions")
	public Iterable<Position> getPositions() {
		System.out.print("Retrieve All Positions");
		return positionSvc.getPositions();
	}
	
	@PutMapping("/updatePosition")
	public Position updatePosition(
			@RequestBody Position position,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "symbol") String symbol,
			@RequestParam(value = "price") Float price,
			@RequestParam(value = "cost") Float cost,
			@RequestParam(value = "total") Float total
			) {
		position = new Position(id, name, symbol, price, cost, total);
		return positionSvc.updatePosition(position);
	}
	
	@PostMapping("/addPosition")
	public Position addPosition(
			@RequestBody Position position,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "symbol") String symbol,
			@RequestParam(value = "price") Float price,
			@RequestParam(value = "cost") Float cost,
			@RequestParam(value = "total") Float total
			) {
		position = new Position(name, symbol, price, cost, total);
		return positionSvc.addPosition(position);
	}

	@DeleteMapping("/deletePosition")
	public String deletePosition(@RequestParam(value = "id") Integer id) {
		positionSvc.deletePosition(id);
		return "Success";
	}	
	
}