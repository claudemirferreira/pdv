package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.ProdutoVenda;

@Repository
public class ProdutoVendaDAO extends GenericDAO<ProdutoVenda> {

	public ProdutoVendaDAO() {
		super(ProdutoVenda.class);
	}
}