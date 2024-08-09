package com.api.service.impl;

import com.api.service.PositionSvc;
import com.api.service.dao.PositionDao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Position;

@Component("positionImpl")
public class PositionImpl implements PositionSvc {
	
	@Autowired
	private PositionDao positionDao;
	
	@Override
	public Optional<Position> getPositionById(Integer id) {
		return positionDao.getPositionById(id);
    }
	
	@Override
	public Iterable<Position> getPositions() {
		return positionDao.getPositions();
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