package com.dailson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailson.cursomc.domain.Category;
import com.dailson.cursomc.repositories.CategoryRepository;
import com.dailson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category search(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"The object was not found! Id: " + id + " type: " + Category.class.getName()));

	}

}
