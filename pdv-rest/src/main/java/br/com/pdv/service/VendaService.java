package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.VendaDTO;

public interface VendaService {

	public List<VendaDTO> findAll();

	public VendaDTO save(VendaDTO dto);

	public VendaDTO update(VendaDTO dto);

	public VendaDTO findId(Long id);

	public void delete(Long id);

	public VendaDTO realizarVenda(VendaDTO dto);

}
