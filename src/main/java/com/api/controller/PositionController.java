package com.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.CreatePositionDto;
import com.api.dto.UpdatePositionDto;
import com.api.dto.Account.CreateAccountDto;
import com.api.model.Position;
import com.api.service.PositionSvc;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class PositionController {
	
	@Autowired
	private PositionSvc positionSvc;
	
	@Autowired
	private Position position;
	
	@GetMapping("/getPositions")
	public ResponseEntity<Object> getPositions() {
		try {
			return ResponseEntity.ok(positionSvc.getPositions());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PutMapping("/updatePosition")
	public ResponseEntity<Object> updatePosition(@Valid @RequestBody UpdatePositionDto updatePositionDto) {		
		try {
			
			BeanUtils.copyProperties(updatePositionDto, position);
			
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
	public ResponseEntity<Object> addPosition(@Valid @RequestBody CreatePositionDto createPositionDto) {
		try {
			
			BeanUtils.copyProperties(createPositionDto, position);
			
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
	public ResponseEntity<Object> deletePosition(@NotNull @RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(positionSvc.deletePosition(id));	
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}	
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		
//		Map<String, String> errors = new HashMap<>();
//		
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		
//		return errors;
//		
//	}
	
}