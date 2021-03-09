package com.dailson.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dailson.cursomc.domain.Client;
import com.dailson.cursomc.dto.ClientDTO;
import com.dailson.cursomc.repositories.ClientRepository;
import com.dailson.cursomc.services.exceptions.DataIntegrityException;
import com.dailson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"The object was not found! Id: " + id + " type: " + Client.class.getName()));
	}

	public Client update(Client obj) {
		Client newObj =  find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	
	public void delete(Integer id) {
		find(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible to delete because there are related entities");
		}

	}

	public List<Client> findAll() {
		return repo.findAll();

	}

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO objectDTO) {
		return new Client(objectDTO.getId(),objectDTO.getName() , objectDTO.getEmail(), null, null);
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

}
