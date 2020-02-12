package com.gustavo.desafiotecnico.desafiotecnico.dev.parsers;

import org.modelmapper.ModelMapper;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.EnderecoDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Endereco;

public class EnderecoParser {

	public EnderecoDTO toDto(Endereco entity){
	ModelMapper mapper = new  ModelMapper();
	EnderecoDTO dto=  mapper.map(entity, EnderecoDTO.class);
	return dto;
	}
}
