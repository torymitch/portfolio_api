package com.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.Checklist.CreateChecklistDto;
import com.api.dto.Checklist.UpdateChecklistDto;
import com.api.model.Checklist;
import com.api.service.ChecklistSvc;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class ChecklistController {

	@Autowired
	private ChecklistSvc checklistSvc;
	
	@Autowired
	private Checklist checklist;
	
	@GetMapping("/getChecklists")
	public ResponseEntity<Object> getChecklists() {
		try {
			return ResponseEntity.ok(checklistSvc.getChecklists());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PostMapping("/addChecklist")
	public ResponseEntity<Object> addChecklist(@Valid @RequestBody CreateChecklistDto createChecklistDto) {
		try {
			
			BeanUtils.copyProperties(createChecklistDto, checklist);
			
			Checklist newChecklist = checklistSvc.addChecklist(checklist);
			if (!ObjectUtils.isEmpty(newChecklist)) {
				return (ResponseEntity.ok(newChecklist));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Checklist Not Created");
	}
	
	@PutMapping("/updateChecklist")
	public ResponseEntity<Object> updateChecklist(@Valid @RequestBody UpdateChecklistDto updateChecklistDto) {
		try {
			BeanUtils.copyProperties(updateChecklistDto, checklist);
			Checklist updChecklist = checklistSvc.updateChecklist(checklist);
			if (!ObjectUtils.isEmpty(updChecklist)) {
				return (ResponseEntity.ok(updChecklist));	
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Account Not Created");
	}
	
	@DeleteMapping("/deleteChecklist")
	public ResponseEntity<Object> deleteChecklist(@NotNull @RequestParam(value = "id") Integer id) {
		try {
			return ResponseEntity.ok(checklistSvc.deleteChecklist(id));	
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
