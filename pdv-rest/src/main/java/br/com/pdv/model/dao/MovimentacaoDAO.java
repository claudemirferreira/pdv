package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Movimentacao;

@Repository
public class MovimentacaoDAO extends GenericDAO<Movimentacao> {

	public MovimentacaoDAO() {
		super(Movimentacao.class);
	}
}