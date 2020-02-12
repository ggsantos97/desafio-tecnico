package com.gustavo.desafiotecnico.desafiotecnico.dev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
		
	
	
}
