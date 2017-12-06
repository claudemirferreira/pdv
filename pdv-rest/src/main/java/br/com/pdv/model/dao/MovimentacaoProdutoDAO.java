package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.MovimentacaoProduto;

@Repository
public class MovimentacaoProdutoDAO extends GenericDAO<MovimentacaoProduto> {

	public MovimentacaoProdutoDAO() {
		super(MovimentacaoProduto.class);
	}
}