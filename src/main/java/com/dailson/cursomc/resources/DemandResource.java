package com.dailson.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dailson.cursomc.domain.Demand;
import com.dailson.cursomc.services.DemandService;

@RestController
@RequestMapping(value = "/demands")
public class DemandResource {

	@Autowired
	private DemandService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Demand obj = service.search(id);
		return ResponseEntity.ok().body(obj);
	}

}
