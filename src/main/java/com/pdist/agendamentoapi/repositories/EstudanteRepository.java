package com.pdist.agendamentoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdist.agendamentoapi.models.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
