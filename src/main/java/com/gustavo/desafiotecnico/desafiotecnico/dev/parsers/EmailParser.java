package com.gustavo.desafiotecnico.desafiotecnico.dev.parsers;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.EmailDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Email;

public class EmailParser extends AbstractParser<EmailDTO, Email>{

	@Override
	public EmailDTO toDTO(Email entity) {
		EmailDTO dto = new EmailDTO();
		dto.setEndereco(entity.getEndereco());
		return dto;
	}

	@Override
	public Email toEntity(EmailDTO dto) {
		Email entity = new Email();
		entity.setEndereco(dto.getEndereco());
		return entity;
	}

}
