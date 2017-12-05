package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Caixa;

@Repository
public class CaixaDAO extends GenericDAO<Caixa> {

	public CaixaDAO(Class<Caixa> entityClass) {
		super(entityClass);
	}
}