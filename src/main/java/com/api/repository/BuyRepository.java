package com.api.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.api.model.Buy;

public interface BuyRepository extends CrudRepository<Buy, Integer> {

//	List<Buy> findAllByPositionId(Integer id);

//	Optional<Buy> findById(Integer i);

}

