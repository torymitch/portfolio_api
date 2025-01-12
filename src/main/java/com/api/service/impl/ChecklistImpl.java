package com.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Checklist;
import com.api.service.ChecklistSvc;
import com.api.service.dao.ChecklistDao;

@Component("checklistImpl")
public class ChecklistImpl implements ChecklistSvc {
	
	@Autowired
	private ChecklistDao checklistDao;


	@Override
	public Iterable<Checklist> getChecklists() {
		return checklistDao.getChecklists();
	}

	@Override
	public Checklist addChecklist(Checklist checklist) {
		return checklistDao.saveChecklist(checklist);
	}

	@Override
	public Checklist updateChecklist(Checklist checklist) {
		return checklistDao.updateChecklist(checklist);
	}

	@Override
	public String deleteChecklist(Integer id) {
		return checklistDao.deleteChecklist(id);
	}

	@Override
	public Optional<Checklist> getChecklistById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
