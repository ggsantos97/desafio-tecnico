package com.gustavo.desafiotecnico.desafiotecnico.dev.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.ExactAnnotationFieldTypePattern;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.ClienteDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Cliente;
import com.gustavo.desafiotecnico.desafiotecnico.dev.parsers.ClienteParser;
import com.gustavo.desafiotecnico.desafiotecnico.dev.repository.ClienteRepository;

import javassist.NotFoundException;


@Service
public class ClienteService {
	
	@Autowired ClienteRepository repository;
	@Autowired ClienteParser parser;
	
//	private Map<String, ClienteDTO> mapCliente = new HashMap<>();
	
	//Obs. Este metódo usa-se como UpSert (Salvar)
//	public  ClienteDTO salvarCliente(ClienteDTO dto)  throws Exception{
//		//clientes.add(dto);
//		//mapCliente.put(dto.getCpf(), dto);
//		repository.getMapCliente().put(dto.getCpf(), dto); 
//		return dto;
//	}
	
//	public Map<String, ClienteDTO> findAll() throws Exception {
//		
//		if (repository.getMapCliente().isEmpty()) {
//			throw new Exception("Não há dados de clientes na base ...");
//		}
//		return repository.getMapCliente();
//	}
	
//	public ClienteDTO atualizarCliente(ClienteDTO dto)   throws Exception{	
//			if(repository.getMapCliente().get(dto.getCpf()) == null) {
//				throw new Exception("Esse cliente não existe");
//			}
//		 repository.getMapCliente().put(dto.getCpf(),dto);			
//		 return dto;
//	}
	
//	public void deletarCliente(ClienteDTO dto) throws Exception{
//		repository.getMapCliente().remove(dto);
//	}
	
		public List<Cliente> findAll() throws Exception{
			List<Cliente> clientes = (List<Cliente>) repository.findAll();
			if(clientes.isEmpty()) {
				 throw new Exception("Não existem clientes");
			}
			return clientes;
		}
		
		
		public Cliente save(Cliente entity) throws Exception {
			//odelMapper mapper = new ModelMapper();
			if(entity.getNome().length() < 3 || entity.getNome().length() > 100) {
				 throw new Exception("O nome deve ter entre 3 a 100 caracteres");
			}
		/*
		 * if(verificaCpf(entity.getCpf())) { throw new
		 * Exception("Já existe este cpf cadastrado na Base de dados"); }
		 */
			else  {
				return  repository.save(entity);
			}
		}
		
		public Cliente findByCpf(String cpf) throws Exception {			
			return repository.findByCpf(cpf);
	}
		private  boolean verificaCpf(String cpf) {
			Cliente c = repository.findByCpf(cpf);
			if(c != null) {
				return true;
			}else {
				return false;
			}
		}
		
		
		public void deleteById(Long id) throws Exception{
			try {
				repository.deleteById(id);
				
			} catch (IllegalArgumentException  e) {
				  throw new Exception("Id não pode está Nulo");
			}
		}				
}
