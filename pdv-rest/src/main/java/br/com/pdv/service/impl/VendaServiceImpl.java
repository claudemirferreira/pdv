package br.com.pdv.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.VendaConvert;
import br.com.pdv.dto.VendaDTO;
import br.com.pdv.model.dao.VendaDAO;
import br.com.pdv.model.entity.Venda;
import br.com.pdv.service.VendaService;

@Service
@Transactional
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaDAO dao;

	@Autowired
	private VendaConvert convert;

	@Override
	public List<VendaDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public VendaDTO save(VendaDTO dto) {
		Venda entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public VendaDTO realizarVenda(VendaDTO dto) {
		dto.setData(new Date());
		return save(dto);
	}

	@Override
	public VendaDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public VendaDTO update(VendaDTO dto) {
		Venda entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}