package com.dailson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailson.cursomc.domain.Demand;
import com.dailson.cursomc.repositories.DemandRepository;
import com.dailson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class DemandService {

	@Autowired
	private DemandRepository repo;
	
	public Demand search(Integer id) {
		Optional<Demand> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"The object was not found! Id: " + id + " type: " + Demand.class.getName()));
	}
	
}
