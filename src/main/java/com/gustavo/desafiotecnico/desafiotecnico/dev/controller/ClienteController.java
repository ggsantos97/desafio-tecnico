package com.gustavo.desafiotecnico.desafiotecnico.dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.ClienteDTO;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {


 @GetMapping 
 public String init(){ 
	 return "Essa é uma mensagem do Back End";
}
 
 @PostMapping
 @ResponseBody
 public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO cliente)throws Exception {
	if(cliente!= null) {
		return ResponseEntity.ok(cliente);
	}
	return ResponseEntity.ok(cliente);
 }


	
}


