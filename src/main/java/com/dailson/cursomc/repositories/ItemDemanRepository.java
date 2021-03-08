package com.dailson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailson.cursomc.domain.ItemDemand;

@Repository
public interface ItemDemanRepository extends JpaRepository<ItemDemand, Integer>{

}
