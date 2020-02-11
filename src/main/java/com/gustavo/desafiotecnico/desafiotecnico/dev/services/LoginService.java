package com.gustavo.desafiotecnico.desafiotecnico.dev.services;

import org.springframework.stereotype.Service;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.LoginDTO;

@Service
public class LoginService {

	
	
	public LoginDTO autenticar(LoginDTO dto) throws Exception  {
		
			if(this.isValid(dto)) {		
				if(dto.getSenha().equals("123456") && (dto.getNome().equals("admin") || dto.getNome().equals("comun"))) {
					
					switch (dto.getNome()) {
					case "admin":
						dto.setLevel("ADMIN");
						break;
					case "comun":
						dto.setLevel("COMUN");
						break;
					default:
						break;
					}
					return dto;
				}			
				else {
					throw new Exception("Usuário ou senha Incorretos !!!");
				}
			}
			throw new Exception("CREDENCIAS INVÁLIDAS");
		}
	
	
			private boolean isValid(LoginDTO dto) {
				if ((dto.getNome() !=null && dto.getNome() != "") && (dto.getSenha() !=null  && dto.getNome() != "")) {
					return true;
				}
				return false;
			}

}
