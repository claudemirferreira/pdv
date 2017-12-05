package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Produto;

@Repository
public class ProdutoDAO extends GenericDAO<Produto> {

	public ProdutoDAO() {
		super(Produto.class);
	}
}