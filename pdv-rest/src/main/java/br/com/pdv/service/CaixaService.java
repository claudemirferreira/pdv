package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.CaixaDTO;

public interface CaixaService {

	public List<CaixaDTO> findAll();

	public CaixaDTO save(CaixaDTO dto);

	public CaixaDTO update(CaixaDTO dto);

	public CaixaDTO findId(Long id);

	public void delete(Long id);

	public boolean existeCaixaAberto(Long clienteId);

	public boolean caixaEstaAberto(Long caixaId);

	public CaixaDTO abrir(CaixaDTO dto);

	public CaixaDTO fechar(CaixaDTO dto);

}
