package com.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.model.Position;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PositionRepository extends CrudRepository<Position, Integer> {

}
