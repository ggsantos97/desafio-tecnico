package com.gustavo.desafiotecnico.desafiotecnico.dev.DTO;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO {
	
	private String nome;
	
	@CPF
	private String cpf;
	private List<TelefoneDTO> telefones;
	
	@Email
	private List<String> emails;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if(nome.length() < 3 || nome.length() > 100) {
			throw new Exception("O tamanho deve conter de 3 a 100 caracteres");
		}
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	
}
