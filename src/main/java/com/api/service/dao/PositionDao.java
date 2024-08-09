package com.api.service.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.model.Position;
import com.api.repository.PositionRepository;

@Component("positionDao")
public class PositionDao {
	
	@Autowired 
	private PositionRepository positionRepository;
	
	public Iterable<Position> getPositions() {
		return positionRepository.findAll();
	}
	
	public Position savePosition(Position position) {
		return positionRepository.save(position);
	}

	public String deletePosition(Integer id) {
		positionRepository.deleteById(id);
		return "Success";
	}

	public Position updatePosition(Position position) {
		Optional<Position> positionToUpd = positionRepository.findById(position.getId());
		if (positionToUpd != null) {
			return positionRepository.save(position);
		}
		return null;
	}

	public Optional<Position> getPositionById(Integer id) {
		return positionRepository.findById(id);
	}
}