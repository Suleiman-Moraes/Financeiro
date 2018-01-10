package com.moraes.financeiro.service;

public class NegocioException extends Exception{
	//Atributos
	private static final long serialVersionUID = 1L;
	
	//Construtor
	public NegocioException(String msg) {
		super(msg);
	}
}
