package com.api.service.impl;

import com.api.service.BuySvc;
import com.api.service.PositionSvc;
import com.api.service.SellSvc;
import com.api.service.dao.PositionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Buy;
import com.api.model.Position;
import com.api.model.Sell;

@Component("positionImpl")
public class PositionImpl implements PositionSvc {
	
	@Autowired
	private PositionDao positionDao;
	
	@Autowired
	private BuySvc buySvc;
	
	@Autowired
	private SellSvc sellSvc;

	
	@Override
	public Optional<Position> getPositionById(Integer id) {
		return positionDao.getPositionById(id);
    }
	
	@Override
	public Iterable<Position> getPositions() {
		
		Iterable<Position> positions = positionDao.getPositions();
		positions.forEach( (position) -> {
			List<Buy> buys = buySvc.findByPositionId(position.getId());
			buys.forEach((buy) -> {
				if (position.getShares() == null) {
					position.setShares(buy.getShares());
				} else {
					position.setShares(position.getShares() + buy.getShares());
				}
				if (position.getTotal() == null) {
					position.setTotal(buy.getTotalCost());	
				} else {
					position.setTotal(position.getTotal() + buy.getTotalCost());
				}
				if (position.getCost() == null) {
					position.setCost(buy.getTotalCost());	
				} else {
					position.setCost(position.getCost() + buy.getTotalCost());
				}
				
			});
			
			List<Sell> sells = sellSvc.findByPositionId(position.getId());
			sells.forEach((sell) -> {
				position.setShares(position.getShares() - sell.getShares());
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
		List<Buy> buys = buySvc.findByPositionId(id);
		buys.forEach((buy) -> {
			buySvc.deleteBuy(buy.getId());
			
		});
		
		List<Sell> sells = sellSvc.findByPositionId(id);
		sells.forEach((sell) -> {
			sellSvc.deleteSell(sell.getId());
			
		});
		
		return positionDao.deletePosition(id);
	}

    
}