package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.MovimentacaoProdutoDTO;

public interface MovimentacaoProdutoService {

	public List<MovimentacaoProdutoDTO> findAll();

	public MovimentacaoProdutoDTO save(MovimentacaoProdutoDTO dto);

	public MovimentacaoProdutoDTO update(MovimentacaoProdutoDTO dto);

	public MovimentacaoProdutoDTO findId(Long id);

	public void delete(Long id);

}