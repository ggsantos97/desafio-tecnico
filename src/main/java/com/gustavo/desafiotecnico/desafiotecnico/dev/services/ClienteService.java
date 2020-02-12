package com.gustavo.desafiotecnico.desafiotecnico.dev.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
		public Iterable<ClienteDTO> findAll() throws Exception{
			ClienteDTO dto ;
			List<ClienteDTO> dtos = new ArrayList<>();
			List<Cliente> entities = new  ArrayList<>();
			entities = (List<Cliente>) repository.findAll();
			for (Cliente cliente : entities) {
				dto = parser.toDTO(cliente);
				dtos.add(dto);
			}
			
			return dtos;
		}
		
		public void save(ClienteDTO dto) throws Exception {
			//odelMapper mapper = new ModelMapper();
			  repository.save(parser.toEntity(dto));
		}
		
		public ClienteDTO findByCpf(String cpf) throws Exception{
			return null;
		}
		
		public void deleteByCpf(String cpf) {
			
		}
}
