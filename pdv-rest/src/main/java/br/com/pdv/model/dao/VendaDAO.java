package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Venda;

@Repository
public class VendaDAO extends GenericDAO<Venda> {

	public VendaDAO() {
		super(Venda.class);
	}
}