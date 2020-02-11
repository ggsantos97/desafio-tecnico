package com.gustavo.desafiotecnico.desafiotecnico.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.LoginDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.services.LoginService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<LoginDTO> autenticar(@RequestBody LoginDTO dto) throws Exception {		
			//LoginDTO login = ;
			return ResponseEntity.ok(loginService.autenticar(dto));
		
	}
	
}
