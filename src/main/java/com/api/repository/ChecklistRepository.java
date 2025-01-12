package com.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.model.Checklist;


public interface ChecklistRepository extends CrudRepository<Checklist, Integer> {

}
