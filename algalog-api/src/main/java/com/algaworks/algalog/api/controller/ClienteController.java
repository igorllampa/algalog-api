package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.ClienteAssembler;
import com.algaworks.algalog.api.model.ClienteModel;
import com.algaworks.algalog.api.model.input.ClienteInput;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;
	private ClienteAssembler clienteAssembler;

	@GetMapping
	public List<ClienteModel> listar() {					
		return clienteAssembler.toCollectionModel(clienteRepository.findAll());				     
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteModel> buscar(@PathVariable Long clienteId) {
		
		return clienteRepository.findById(clienteId)
				.map(entrega -> ResponseEntity.ok(clienteAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());			
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar (@Valid @RequestBody ClienteInput clienteInput) {		
		Cliente clienteNovo = catalogoClienteService.salvar(clienteAssembler.toEntity(clienteInput));
		return clienteAssembler.toModel(clienteNovo);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<ClienteModel> atualizar(@Valid @PathVariable Long clienteId, @RequestBody ClienteInput clienteInput) {
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente cliente = clienteAssembler.toEntity(clienteInput);
		
		cliente.setId(clienteId);
		cliente = catalogoClienteService.salvar(cliente);		
		return ResponseEntity.ok(clienteAssembler.toModel(cliente));			
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}					
		catalogoClienteService.excluir(clienteId);		
		return ResponseEntity.noContent().build();		
	}
}
