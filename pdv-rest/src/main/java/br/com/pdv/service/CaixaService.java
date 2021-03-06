package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.CaixaDTO;

public interface CaixaService {

	public List<CaixaDTO> findAll();

	public CaixaDTO save(CaixaDTO dto);

	public CaixaDTO update(CaixaDTO dto);

	public CaixaDTO findId(Long id);

	public void delete(Long id);

}
