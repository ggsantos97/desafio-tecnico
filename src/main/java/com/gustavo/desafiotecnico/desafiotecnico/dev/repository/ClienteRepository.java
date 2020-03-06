package com.gustavo.desafiotecnico.desafiotecnico.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
		
	Cliente findByCpf(String cpf);
	
	
}
