package com.moraes.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.moraes.financeiro.model.Pessoa;
import com.moraes.financeiro.repository.Pessoas;
import com.moraes.financeiro.util.JpaUtil;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter{
	
	@Inject // funciona graças ao OmniFaces
	private Pessoas pessoas;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if (value != null) retorno = this.pessoas.porId(new Long(value));
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) return ((Pessoa) value).getId().toString();
		
		return null;
	}
}
