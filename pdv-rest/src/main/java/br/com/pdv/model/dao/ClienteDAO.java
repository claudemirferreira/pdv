package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Cliente;

@Repository
public class ClienteDAO extends GenericDAO<Cliente> {

	public ClienteDAO(Class<Cliente> entityClass) {
		super(entityClass);
	}
}