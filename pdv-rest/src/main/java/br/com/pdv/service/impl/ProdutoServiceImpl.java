package br.com.pdv.service.impl;

import br.com.pdv.controller.param.ProdutoFilter;
import br.com.pdv.convert.ProdutoConvert;
import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.model.entity.Produto;
import br.com.pdv.repository.ProdutoRepository;
import br.com.pdv.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
	public Page<ProdutoDTO> filter(ProdutoFilter fileter, Integer page, Integer size) {
		final PageRequest pageRequest = getPageRequest(page, size);
		final Page<Produto> result = filterProdutoPaginated(fileter, page, size);
		return result.map(this::getProdutoDto);
	}

	private Page<Produto> filterProdutoPaginated(ProdutoFilter fileter, Integer page, Integer size) {
		final PageRequest pageRequest = getPageRequest(page, size);
		Page<Produto> result;

		if (Objects.nonNull(pageRequest)) {
			result = produtoRepository.findAll(getSpecifications(fileter), pageRequest);
		} else {
			final List<Produto> produtos = produtoRepository.findAll(getSpecifications(fileter));
			result = new PageImpl<>(produtos);
		}

		return result;
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

	private Specification<Produto> getSpecifications(final ProdutoFilter filter) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if(filter.getNome() != null && !filter.getNome().isEmpty()) {
				predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"));
			}

			if(filter.getCodigoBarra() != null && !filter.getCodigoBarra().isEmpty()) {
				predicates.add(builder.like(builder.lower(root.get("codigoBarra")), "%" + filter.getCodigoBarra().toLowerCase() + "%"));
			}

			query.orderBy(builder.asc(root.get("nome")));

			return builder.and(predicates.toArray(new Predicate[]{}));
		};
	}

	private PageRequest getPageRequest(final Integer page, final Integer size) {
		if ((page != null && size != null) && (page != -1 && size != -1)) {
			return new PageRequest(page, size, new Sort(Sort.Direction.ASC, Produto.PRODUTO_NOME));
		}
		return null;
	}

	private ProdutoDTO getProdutoDto(Produto produto) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setProduto(produto);
		return dto;
	}

}