package com.pdist.agendamentoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdist.agendamentoapi.models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
