package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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
	public ResponseEntity<Iterable<Position>> getPositions() {
		System.out.print("Retrieve All Positions");
		return ResponseEntity.ok(positionSvc.getPositions());
	}
	
	@PutMapping("/updatePosition")
	public ResponseEntity<Position> updatePosition(
			@RequestBody Position position,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "symbol") String symbol,
			@RequestParam(value = "price") Float price,
			@RequestParam(value = "cost") Float cost,
			@RequestParam(value = "total") Float total
			) {
		position = new Position(id, name, symbol, price, cost, total);
		return ResponseEntity.ok(positionSvc.updatePosition(position));
	}
	
	@PostMapping("/addPosition")
	public ResponseEntity<Position> addPosition(
			@RequestBody Position position,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "symbol") String symbol,
			@RequestParam(value = "price") Float price,
			@RequestParam(value = "cost") Float cost,
			@RequestParam(value = "total") Float total
			) {
		position = new Position(name, symbol, price, cost, total);
		return ResponseEntity.ok(positionSvc.addPosition(position));
	}

	@DeleteMapping("/deletePosition")
	public BodyBuilder deletePosition(@RequestParam(value = "id") Integer id) {
		positionSvc.deletePosition(id);
		return ResponseEntity.ok();
	}	
	
}