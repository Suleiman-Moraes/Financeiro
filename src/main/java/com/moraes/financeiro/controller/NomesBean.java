package com.moraes.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
@ViewScoped
public class NomesBean {
	//Atributos
	private String nome;
	private List<String> nomes = new ArrayList<>();
	
	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdicionar;
	
	//Metodos
	public String adicionar() {
		this.nomes.add(nome);
		
		// desativa campo e botão quando mais que 3 nomes
		// forem adicionados
		if (this.nomes.size() > 3) {
			this.inputNome.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Muitos nomes adicionados...");
			
			return "Ola?faces-redirect=true";
		}
		return null;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HtmlInputText getInputNome() {
		return inputNome;
	}

	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}

	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}
	
}
