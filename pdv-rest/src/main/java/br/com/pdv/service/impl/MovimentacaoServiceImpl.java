package br.com.pdv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.MovimentacaoConvert;
import br.com.pdv.dto.MovimentacaoDTO;
import br.com.pdv.model.dao.MovimentacaoDAO;
import br.com.pdv.model.entity.Movimentacao;
import br.com.pdv.service.MovimentacaoService;

@Service
@Transactional
public class MovimentacaoServiceImpl implements MovimentacaoService {

	@Autowired
	private MovimentacaoDAO dao;

	@Autowired
	private MovimentacaoConvert convert;

	@Override
	public List<MovimentacaoDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public MovimentacaoDTO save(MovimentacaoDTO dto) {
		Movimentacao entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public MovimentacaoDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public MovimentacaoDTO update(MovimentacaoDTO dto) {
		Movimentacao entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}