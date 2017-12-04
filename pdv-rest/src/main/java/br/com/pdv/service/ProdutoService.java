package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.model.entity.Produto;

public interface ProdutoService {

	public List<ProdutoDTO> findAll();

	public ProdutoDTO save(Produto produto);

	public ProdutoDTO findId(Long id);

	public void delete(Long id);

}
