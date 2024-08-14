package com.api.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Sell;

@Repository
public interface SellRepository extends CrudRepository<Sell, Integer> {

	List<Sell> findByPositionId(Integer id);

}

