package com.pdist.agendamentoapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pdist.agendamentoapi.models.Estudante;
import com.pdist.agendamentoapi.services.AdministradorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/administrador/estudante")
public class AdministradorController {

	@Autowired
	private AdministradorService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estudante>> buscarTodos() {
		List<Estudante> lista = service.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estudante> buscarPorId(@PathVariable Long id) {
		Estudante obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Estudante obj) {
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@PathVariable Long id, @RequestBody Estudante obj) {
		obj.setId(id);
		obj = service.alterar(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
}
