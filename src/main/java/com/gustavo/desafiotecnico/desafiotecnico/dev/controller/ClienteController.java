package com.gustavo.desafiotecnico.desafiotecnico.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.desafiotecnico.desafiotecnico.dev.DTO.ClienteDTO;
import com.gustavo.desafiotecnico.desafiotecnico.dev.config.MensagemErro;
import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Cliente;
import com.gustavo.desafiotecnico.desafiotecnico.dev.model.Message;
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
	public ResponseEntity<Iterable<Cliente>> findAll() throws Exception{
		return  ResponseEntity.ok(service.findAll());
	}
	
	/*
	 * @GetMapping(value = "/{cpf}") public ResponseEntity<ClienteDTO>
	 * findByCpf(@PathVariable (name = "cpf") String cpf) throws Exception{ return
	 * ResponseEntity.ok(service.findByCpf(cpf)); }
	 */
	
	@DeleteMapping(value = "/{id}/{level}")
 		public ResponseEntity<Message> deleteByCpf(@PathVariable (name = "id")  Long id, @PathVariable (name = "level") String level) throws Exception{
		if(level.equals("ADMIN")) {
			Message m = new Message();	
			service.deleteById(id);
			m.setMensagem("Cliente Excluído com Sucesso");
			return ResponseEntity.ok(m);				
		}
		throw new Exception("Você não tem autorização para realizar essa operação !!");
	}
	@PostMapping
	public ResponseEntity<Message> save(@RequestBody Cliente cliente, String level )throws Exception{
		Message m = new Message();
		try {
			if(cliente.getId() != null) {
				service.save(cliente);
				m.setMensagem("Cliente Alterado com sucesso !!!");
				return ResponseEntity.ok(m);
			}else {
				service.save(cliente);
				m.setMensagem("Cliente Salvo com sucesso !!!");			
			}
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		return ResponseEntity.ok(m);
	}
}


