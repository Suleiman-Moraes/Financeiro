package com.moraes.financeiro.model;

import java.io.Serializable;
import java.math.BigDecimal;
//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
	// Atributos
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Pessoa pessoa;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipo;
	private Date dataVencimento;
	private Date dataPagamento;

	// Metodos
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "pessoa_id")
	public Pessoa getPessoa() {
		return pessoa;
	}

	@Column(length = 80, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValor() {
		return valor;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoLancamento getTipo() {
		return tipo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento", nullable = false)
	public Date getDataVencimento() {
		return dataVencimento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_pagamento", nullable = true)
	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	// hashCode e equals
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
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
