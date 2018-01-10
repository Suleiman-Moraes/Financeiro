package com.moraes.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.moraes.financeiro.model.Pessoa;

public class Pessoas implements Serializable{
	//Atributos
	private static final long serialVersionUID = 1L;
	private EntityManager manager;
	
	//Construtor
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	
	//Metodos
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todas(){
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}
}
