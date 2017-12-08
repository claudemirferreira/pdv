package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.MovimentacaoDTO;

public interface MovimentacaoService {

	public List<MovimentacaoDTO> findAll();

	public MovimentacaoDTO save(MovimentacaoDTO dto);

	public MovimentacaoDTO update(MovimentacaoDTO dto);

	public MovimentacaoDTO findId(Long id);

	public void delete(Long id);

}