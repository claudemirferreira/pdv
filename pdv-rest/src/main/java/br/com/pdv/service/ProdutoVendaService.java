package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.ProdutoVendaDTO;

public interface ProdutoVendaService {

	public List<ProdutoVendaDTO> findAll();

	public ProdutoVendaDTO save(ProdutoVendaDTO dto);

	public ProdutoVendaDTO update(ProdutoVendaDTO dto);

	public ProdutoVendaDTO findId(Long id);

	public void delete(Long id);

}
