package br.com.pdv.service;

import java.awt.print.Pageable;
import java.util.List;

import br.com.pdv.controller.param.ProdutoFilter;
import br.com.pdv.dto.ProdutoDTO;
import org.springframework.data.domain.Page;

public interface ProdutoService {

	public List<ProdutoDTO> findAll();

	public Page<ProdutoDTO> filter(ProdutoFilter produtoFilter, Integer page, Integer size);

	public ProdutoDTO save(ProdutoDTO dto);

	public ProdutoDTO update(ProdutoDTO dto);

	public ProdutoDTO findId(Long id);

	public void delete(Long id);

}
