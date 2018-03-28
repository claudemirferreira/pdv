package br.com.pdv.service.impl;

import br.com.pdv.convert.ProdutoConvert;
import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.model.dao.ProdutoVendaDAO;
import br.com.pdv.model.entity.Produto;
import br.com.pdv.repository.ProdutoRepository;
import br.com.pdv.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoConvert convert;

	@Override
	public List<ProdutoDTO> findAll() {
		return convert.convertToDTO(produtoRepository.findAll());
	}

	@Override
	@Transactional
	public ProdutoDTO save(ProdutoDTO dto) {
		Produto produto = convert.convertToEntity(dto);
		produto = produtoRepository.save(produto);
		return convert.convertToDTO(produto);
	}

	@Override
	public ProdutoDTO findId(Long id) {
		return convert.convertToDTO(produtoRepository.findOne(id));
	}

	@Override
	public void delete(Long id) {
		produtoRepository.delete(id);
	}

	@Override
	public ProdutoDTO update(ProdutoDTO dto) {
		Produto entity = produtoRepository.save(convert.convertToEntity(dto)) ;
		return convert.convertToDTO(entity);
	}

}