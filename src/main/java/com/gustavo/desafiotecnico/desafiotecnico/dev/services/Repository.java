package com.gustavo.desafiotecnico.desafiotecnico.dev.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.ClienteDTO;

@Service
public class Repository {

	private Map<String, ClienteDTO> mapCliente = new HashMap<>();

	public Map<String, ClienteDTO> getMapCliente() {
		return mapCliente;
	}

	public void setMapCliente(Map<String, ClienteDTO> mapCliente) {
		this.mapCliente = mapCliente;
	}



}
