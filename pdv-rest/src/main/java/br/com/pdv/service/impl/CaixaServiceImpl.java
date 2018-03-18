package br.com.pdv.service.impl;

import br.com.pdv.convert.CaixaConvert;
import br.com.pdv.dto.CaixaDTO;
import br.com.pdv.dto.UsuarioDTO;
import br.com.pdv.enumerated.StatusCaixaEnum;
import br.com.pdv.model.dao.CaixaDAO;
import br.com.pdv.model.entity.Caixa;
import br.com.pdv.model.entity.Usuario;
import br.com.pdv.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CaixaServiceImpl implements CaixaService {

	@Autowired
	private CaixaDAO dao;

	@Autowired
	private CaixaConvert convert;

	@Override
	public List<CaixaDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public CaixaDTO save(CaixaDTO dto) {
		Caixa entity = convert.convertToEntity(dto);
		return convert.convertToDTO(dao.save(entity));
	}

	@Override
	public CaixaDTO abrir(CaixaDTO dto) {
		if (existeCaixaAberto(dto.getUsuario().getId())) {
			dto.setDataAbertura(new Date());
			dto.setStatusCaixa(StatusCaixaEnum.ABERTO);
			return save(dto);
		}
		return null;
	}

	@Override
	public CaixaDTO fechar(CaixaDTO dto) {
		if (caixaEstaAberto(dto.getId())) {
			dto.setDataFechamento(new Date());
			dto.setStatusCaixa(StatusCaixaEnum.FECHADO);
			return save(dto);
		}
		return null;
	}

	@Override
	public CaixaDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public boolean existeCaixaAberto(Long clienteId) {
		return dao.existeCaixaAberto(clienteId);
	}

	@Override
	public boolean caixaEstaAberto(Long caixaId) {
		return dao.caixaEstaAberto(caixaId);
	}

	@Override
	public CaixaDTO update(CaixaDTO dto) {
		Caixa entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}