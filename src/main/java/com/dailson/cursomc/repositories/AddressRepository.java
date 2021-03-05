package com.dailson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailson.cursomc.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
