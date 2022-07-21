package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {
	
	private ClienteRepository clienteRepository; 	

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		/*
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Tetse");
		cliente1.setEmail("email");
		cliente1.setTelefone("1111111");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Joao");
		cliente2.setEmail("email");
		cliente2.setTelefone("222222222");
		
		return Arrays.asList(cliente1, cliente2);
		*/
		
		return clienteRepository.findAll();				     
	}
}
