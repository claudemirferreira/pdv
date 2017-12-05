package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.ProdutoDTO;

public interface ProdutoService {

	public List<ProdutoDTO> findAll();

	public ProdutoDTO save(ProdutoDTO dto);

	public ProdutoDTO findId(Long id);

	public void delete(Long id);

}
