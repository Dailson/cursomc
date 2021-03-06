package com.dailson.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailson.cursomc.domain.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer>{

}
