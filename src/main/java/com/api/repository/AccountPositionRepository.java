package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.model.AccountPosition;

public interface AccountPositionRepository extends CrudRepository<AccountPosition, Integer> {

//	@Query("select ap.accountId, ap.positionId, a.name, p.name, b.shares, s.shares "
//			+ "FROM AccountPosition ap "
//			+ "JOIN Account a ON ap.accountId = a.id "
//			+ "JOIN Position p ON ap.positionId = p.id "
//			+ "JOIN Buy b ON a.id = b.accountId "
//			+ "JOIN Sell s ON a.id = s.accountId "
//			+ "WHERE ap.accountId = ?1")
//	List<AccountPosition> findByAccountId(Integer id);
	
	@Query("select ap.accountId, ap.positionId "
			+ "FROM AccountPosition ap "
			+ "WHERE ap.accountId=?1")
	List<AccountPosition> findByAccountId(Integer id);
	
	
	@Query("select ap FROM AccountPosition ap WHERE ap.positionId=?1")
	List<AccountPosition> findByPositionId(Integer id);

}
