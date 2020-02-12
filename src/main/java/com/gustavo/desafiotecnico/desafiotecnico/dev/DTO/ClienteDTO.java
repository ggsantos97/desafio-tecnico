package com.gustavo.desafiotecnico.desafiotecnico.dev.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

public class ClienteDTO {
	
	private String nome;
	
	private String cpf;
	private EnderecoDTO endereco;
	private List<TelefoneDTO> telefones =   new ArrayList<TelefoneDTO>();
	private List<EmailDTO> emails = new  ArrayList<EmailDTO>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
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
	public List<EmailDTO> getEmails() {
		return emails;
	}
	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	
	
}
