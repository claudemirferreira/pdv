package br.com.pdv.model.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.pdv.model.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}