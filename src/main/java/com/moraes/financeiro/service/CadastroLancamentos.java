package com.moraes.financeiro.service;

import java.io.Serializable;
import java.util.Date;

import com.moraes.financeiro.model.Lancamento;
import com.moraes.financeiro.repository.Lancamentos;

public class CadastroLancamentos implements Serializable{
	//Atributos
	private static final long serialVersionUID = 1L;
	
	private Lancamentos lancamentos;

	//Construtor
	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	//Metodos
	public void salvar(Lancamento lancamento) throws NegocioException{
		if(lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date()))
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		
		this.lancamentos.adicionar(lancamento);
	}
}
