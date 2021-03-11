package com.dailson.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailson.cursomc.domain.Address;
import com.dailson.cursomc.domain.City;
import com.dailson.cursomc.domain.Client;
import com.dailson.cursomc.domain.enums.ClientType;
import com.dailson.cursomc.dto.ClientDTO;
import com.dailson.cursomc.dto.ClientNewDTO;
import com.dailson.cursomc.repositories.AddressRepository;
import com.dailson.cursomc.repositories.ClientRepository;
import com.dailson.cursomc.services.exceptions.DataIntegrityException;
import com.dailson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	@Autowired
	private AddressRepository addressRepository;
	/*
	 * @Autowired private CityRepository cityRepo;
	 */

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"The object was not found! Id: " + id + " type: " + Client.class.getName()));
	}

	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addressRepository.saveAll(obj.getAddresses());
		
		return obj;
	}

	public Client update(Client obj) {
		Client newObj = find(obj.getId());
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

	public Client fromDTO(ClientDTO objDTO) {
		return new Client(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null);
	}

	public Client fromDTO(ClientNewDTO objDTO) {
		Client cli = new Client(null, objDTO.getName(), objDTO.getName(), objDTO.getCpfOrCnpj(), ClientType.toEnum(objDTO.getClientType()));
		
		City city = new City(objDTO.getCityId(), null, null);
		
		Address addr = new Address(null, objDTO.getStreet(), objDTO.getNumber(), objDTO.getComplement(), objDTO.getDistrict(), objDTO.getPostCode(), cli, city);
		
		cli.getAddresses().add(addr);
		cli.getTelephones().add(objDTO.getTelephone1());
		
		if (objDTO.getTelephone2() != null) {
			cli.getTelephones().add(objDTO.getTelephone2());
		}

		if (objDTO.getTelephone3() != null) {
			cli.getTelephones().add(objDTO.getTelephone3());
		}
		return cli;
	}

	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

}
