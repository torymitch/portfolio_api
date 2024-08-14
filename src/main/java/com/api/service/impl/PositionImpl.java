package com.api.service.impl;

import com.api.service.BuySvc;
import com.api.service.PositionSvc;
import com.api.service.dao.PositionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Buy;
import com.api.model.Position;

@Component("positionImpl")
public class PositionImpl implements PositionSvc {
	
	@Autowired
	private PositionDao positionDao;
	
	@Autowired
	private BuySvc buySvc;
	
	
	@Override
	public Optional<Position> getPositionById(Integer id) {
		return positionDao.getPositionById(id);
    }
	
	@Override
	public Iterable<Position> getPositions() {
		
		Iterable<Position> positions = positionDao.getPositions();
		positions.forEach( (position) -> {
//			List<Buy> buys = buySvc.findByShares(56f);
			List<Buy> buys = buySvc.findByPositionId(position.getId());
//			Optional<Buy> optionalBuy = buySvc.findById(position.getId());
//			Buy buy = optionalBuy.get();
			buys.forEach((buy) -> {
				position.setShares(buy.getShares());
				position.setTotal(buy.getCost());
				position.setCost(buy.getTotalCost());
			});
		});
		return positions;
	}
	
	@Override
	public Position addPosition(Position position) {
		return positionDao.savePosition(position);
	}

	@Override
	public Position updatePosition(Position position) {
		return positionDao.updatePosition(position);
	}

	@Override
	public String deletePosition(Integer id) {
		return positionDao.deletePosition(id);
	}

    
}