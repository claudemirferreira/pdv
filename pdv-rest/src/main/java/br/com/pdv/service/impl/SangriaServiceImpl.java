package br.com.pdv.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import br.com.pdv.model.dao.CaixaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.SangriaConvert;
import br.com.pdv.dto.SangriaDTO;
import br.com.pdv.model.dao.SangriaDAO;
import br.com.pdv.model.entity.Sangria;
import br.com.pdv.service.SangriaService;

@Service
@Transactional
public class SangriaServiceImpl implements SangriaService {

	@Autowired
	private SangriaDAO dao;

	@Autowired
	private CaixaDAO caixaDao;

	@Autowired
	private SangriaConvert convert;

	@Override
	public List<SangriaDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public SangriaDTO save(SangriaDTO dto) {
		if ( caixaDao.caixaEstaAberto(dto.getCaixa().getId()) ){
			Sangria entity = convert.convertToEntity(dto);
			entity.setData(new Date());
			entity = dao.save(entity);
			return convert.convertToDTO(entity);
		}
		return null;
	}

	@Override
	public SangriaDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public SangriaDTO update(SangriaDTO dto) {
		Sangria entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}