package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.util.ObjectUtils;
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
	public ResponseEntity<Object> getPositions() {
		try {
			return ResponseEntity.ok(positionSvc.getPositions());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PutMapping("/updatePosition")
	public ResponseEntity<Object> updatePosition(@RequestBody Position position) {		
		try {
			Position updPosition = positionSvc.updatePosition(position);
			if (!ObjectUtils.isEmpty(updPosition)) {
				return (ResponseEntity.ok(updPosition));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Position Not Created");
	}
	
	@PostMapping("/addPosition")
	public ResponseEntity<Object> addPosition(@RequestBody Position position) {
		try {
			Position newPosition = positionSvc.addPosition(position);
			if (!ObjectUtils.isEmpty(newPosition)) {
				return (ResponseEntity.ok(newPosition));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Position Not Created");

	}

	@DeleteMapping("/deletePosition")
	public ResponseEntity<Object> deletePosition(@RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(positionSvc.deletePosition(id));	
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}	
	
}