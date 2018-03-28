package br.com.pdv.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import br.com.pdv.convert.ProdutoVendaConvert;
import br.com.pdv.dto.ProdutoVendaDTO;
import br.com.pdv.model.dao.ProdutoVendaDAO;
import br.com.pdv.model.entity.ProdutoVenda;
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
	private ProdutoVendaDAO produtoVendaDAO;

	@Autowired
	private VendaConvert convert;

	@Autowired
	private ProdutoVendaConvert produtoVendaConvert;

	@Override
	public List<VendaDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	@Transactional()
	public VendaDTO save(VendaDTO dto) {
		dto.setData(new Date());
		Venda entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Transactional()
	public VendaDTO realizarVenda(VendaDTO dto) {
		dto.setData(new Date());
		Venda entity = dao.save(convert.convertToEntity(dto));
		entity.getProdutoVendas().stream().forEach(l -> {
			l.setVenda(new Venda());
			l.getVenda().setId(entity.getId());
			produtoVendaDAO.save(l);
		});
		return convert.convertToDTO(entity);
	}

	@Transactional
	public VendaDTO salvarProdutos(VendaDTO dto) {
		Venda entity = convert.convertToEntity(dto);
		entity.getProdutoVendas().stream().forEach(l -> {
			l.setVenda(new Venda());
			l.getVenda().setId(entity.getId());
			produtoVendaDAO.save(l);
		});
		return convert.convertToDTO(entity);
	}

	@Override
	public VendaDTO findId(Long id) {
		Venda venda = dao.findId(id);
		return convert.convertToDTO(venda);
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