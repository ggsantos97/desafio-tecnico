package com.gustavo.desafiotecnico.desafiotecnico.dev.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

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
			List<Cliente> clientes = repository.findAll();
			if(clientes.isEmpty()) {
				 throw new Exception("Não existem clientes");
			}
			return clientes;
		}
		
		@Transactional
		public Cliente save(Cliente entity) throws Exception {
			//odelMapper mapper = new ModelMapper();
			if(entity.getNome().length() < 3 || entity.getNome().length() > 100) {
				 throw new Exception("O nome deve ter entre 3 a 100 caracteres");
			}else  {
				return  repository.save(entity);				
			}
		}
		
		public ClienteDTO findByCpf(String cpf) throws Exception {	
			ClienteDTO dto = parser.toDTO(repository.findByCpf(cpf));	
			return dto;
	}
		
		
		public void deleteByCpf(String cpf) throws Exception{
			try {
				Cliente entity = repository.findByCpf(cpf);	
				if(entity.getCpf() != null) {
					repository.delete(entity);									
				}
				throw new NoResultException("Este cpf não exite");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
}
