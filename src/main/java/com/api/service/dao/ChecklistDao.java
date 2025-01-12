package com.api.service.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Checklist;
import com.api.repository.ChecklistRepository;

@Component("checklistDao")
public class ChecklistDao {
	
	@Autowired 
	private ChecklistRepository checklistRepository;
	
	public Iterable<Checklist> getChecklists() {
		return checklistRepository.findAll();
	}
	
	public Checklist saveChecklist(Checklist checklist) {
		return checklistRepository.save(checklist);
	}

	public String deleteChecklist(Integer id) {
		checklistRepository.deleteById(id);
		return "Success";
	}

	public Checklist updateChecklist(Checklist checklist) {
		Optional<Checklist> checklistToUpd = checklistRepository.findById(checklist.getId());
		if (checklistToUpd != null) {
			return checklistRepository.save(checklist);
		}
		return null;
	}

	public Optional<Checklist> getChecklistById(Integer id) {
		return checklistRepository.findById(id);
	}
}