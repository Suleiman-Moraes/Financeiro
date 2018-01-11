package com.moraes.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.moraes.financeiro.model.Lancamento;
import com.moraes.financeiro.model.Pessoa;
import com.moraes.financeiro.model.TipoLancamento;
import com.moraes.financeiro.repository.Lancamentos;
import com.moraes.financeiro.repository.Pessoas;
import com.moraes.financeiro.service.CadastroLancamentos;
import com.moraes.financeiro.service.NegocioException;
import com.moraes.financeiro.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {
	// Atributos
	private static final long serialVersionUID = 1L;

	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> todasPessoas;

	// Moetodos
	public void prepararCadastro() {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Pessoas pessoas = new Pessoas(manager);
			this.todasPessoas = pessoas.todas();
		} finally {
			manager.close();
		}
	}

	public void salvar() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroLancamentos cadastro = new CadastroLancamentos(new Lancamentos(manager));
			cadastro.salvar(this.lancamento);

			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));

			trx.commit();
		} catch (NegocioException e) {
			trx.rollback();

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}
	
	public void descricaoModificada(ValueChangeEvent event) {
		System.out.println("Valor antigo: " + event.getOldValue());
		System.out.println("Novo valor: " + event.getNewValue());
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	//Getters e Setters
	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
}
