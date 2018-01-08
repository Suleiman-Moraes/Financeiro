package com.moraes.financeiro.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "ola")
public class OlaBean {
	//Atributos
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	
	//Metodos
	public void dizerOla() {
		this.nomeCompleto = this.nome.toUpperCase() + " " + this.sobrenome;
	}
	
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
