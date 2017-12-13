package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.SangriaDTO;

public interface SangriaService {

	public List<SangriaDTO> findAll();

	public SangriaDTO save(SangriaDTO dto);

	public SangriaDTO update(SangriaDTO dto);

	public SangriaDTO findId(Long id);

	public void delete(Long id);

}
