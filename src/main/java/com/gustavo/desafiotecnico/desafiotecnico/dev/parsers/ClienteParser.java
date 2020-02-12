package com.gustavo.desafiotecnico.desafiotecnico.dev.parsers;

import javax.annotation.ManagedBean;

import org.modelmapper.ModelMapper;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.ClienteDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Cliente;

@ManagedBean
public class ClienteParser  extends AbstractParser<ClienteDTO, Cliente>{

	@Override
	public ClienteDTO toDTO(Cliente entity)  {
		ModelMapper mapper = new  ModelMapper();
		ClienteDTO dto = mapper.map(entity, ClienteDTO.class);
		return dto;
	}

	@Override
	public Cliente toEntity(ClienteDTO dto) {
		ModelMapper mapper = new  ModelMapper();
		Cliente entity = mapper.map(dto, Cliente.class);
		return entity;
	}

}
