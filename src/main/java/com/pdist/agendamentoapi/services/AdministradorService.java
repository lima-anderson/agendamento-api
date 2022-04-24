package com.pdist.agendamentoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pdist.agendamentoapi.models.Estudante;
import com.pdist.agendamentoapi.repositories.EstudanteRepository;
import com.pdist.agendamentoapi.services.exceptions.DataIntegrityException;
import com.pdist.agendamentoapi.services.exceptions.ObjectNotFoundException;

@Service
public class AdministradorService {

	@Autowired
	private EstudanteRepository repo;

	public List<Estudante> buscarTodos() {
		return repo.findAll();
	}

	public Estudante buscarPorId(Long id) {
		Optional<Estudante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estudante.class.getName()));
	}

	public Estudante inserir(Estudante obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Estudante alterar(Estudante obj) {
		buscarPorId(obj.getId());
		return repo.save(obj);
	}

	public void apagar(Long id) {
		buscarPorId(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir estudante que possui produtos.");
		}
	}
}
