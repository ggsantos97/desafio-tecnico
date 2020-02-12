package com.gustavo.desafiotecnico.desafiotecnico.dev.controller;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.ClienteDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.services.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

// @GetMapping 
// public ResponseEntity<Map<String,ClienteDTO>> listarClientes() throws Exception{ 
//	 return ResponseEntity.ok(service.findAll());
//}
 
// 	@PostMapping
// 	@ResponseBody
// 	public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO cliente)throws Exception {
//	if(cliente!= null) {
//		return ResponseEntity.ok(service.salvarCliente(cliente));
//	}
//	return ResponseEntity.ok(cliente);
// }
 
// 	@PutMapping( path = "/{cpf}")
// 	@ResponseBody
// 	public ResponseEntity<ClienteDTO> atualizar(@RequestBody ClienteDTO cliente, @PathVariable String cpf) throws Exception {
// 		if (cliente != null || cliente.getCpf() != null) {
// 			return ResponseEntity.ok(service.atualizarCliente(cliente));
// 		}
//		throw new Exception("Formulário inválido");
// 	}

	@GetMapping
	public ResponseEntity<Iterable<ClienteDTO>> findAll() throws Exception{
		return  ResponseEntity.ok(service.findAll());
	}
 		
	@PostMapping
	public ResponseEntity<String> save(@RequestBody ClienteDTO cliente)throws Exception{
		service.save(cliente);
		return ResponseEntity.ok("Cliente Salvo com sucesso !!!");
	}
}


