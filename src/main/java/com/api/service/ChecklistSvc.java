package com.api.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.Checklist;

@Component("checklistSvc")
public interface ChecklistSvc {
	
	public Iterable<Checklist> getChecklists();
	
	public Checklist addChecklist(Checklist checklist);
	
	public Checklist updateChecklist(Checklist checklist);

	public String deleteChecklist(Integer id);

	public Optional<Checklist> getChecklistById(Integer id);


}
	