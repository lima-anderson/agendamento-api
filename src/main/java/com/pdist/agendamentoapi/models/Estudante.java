package com.pdist.agendamentoapi.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String senha;

	private String curso;

	private Date diaDeCozinhar;

	private Date diaDeLimpar;

	public Estudante() {
		super();
	}

	public Estudante(String nome, String email, String senha, String curso) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Date getDiaDeCozinhar() {
		return diaDeCozinhar;
	}

	public void setDiaDeCozinhar(Date diaDeCozinhar) {
		this.diaDeCozinhar = diaDeCozinhar;
	}

	public Date getDiaDeLimpar() {
		return diaDeLimpar;
	}

	public void setDiaDeLimpar(Date diaDeLimpar) {
		this.diaDeLimpar = diaDeLimpar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
