package com.api.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.model.Position;

@Component("positionSvc")
public interface PositionSvc {
	
	public Iterable<Position> getPositions();
	
	public Position addPosition(Position position);
	
	public Position updatePosition(Position position);

	public String deletePosition(Integer id);

	public Optional<Position> getPositionById(Integer id);
	
}
	