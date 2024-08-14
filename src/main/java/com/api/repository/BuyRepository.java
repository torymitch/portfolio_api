package com.api.repository;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Buy;

@Repository
public interface BuyRepository extends CrudRepository<Buy, Integer> {

	List<Buy> findByShares(Float shares);
	
//	List<Buy> findByPosition_Id(Integer id);

	List<Buy> findByPositionId(Integer id);

//	Optional<Buy> findById(Integer i);

}

