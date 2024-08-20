package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.model.AccountPosition;

public interface AccountPositionRepository extends CrudRepository<AccountPosition, Integer> {

	@Query("select ap FROM AccountPosition ap WHERE ap.accountId = ?1")
	List<AccountPosition> findByAccountId(Integer id);
	
	
	@Query("select ap FROM AccountPosition ap WHERE ap.positionId = ?1")
	List<AccountPosition> findByPositionId(Integer id);

}
