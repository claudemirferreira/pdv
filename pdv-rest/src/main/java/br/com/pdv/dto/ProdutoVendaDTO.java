package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.pdv.model.entity.Produto;
import br.com.pdv.model.entity.Venda;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("produtoVenda")
public class ProdutoVendaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private Long id;

	private BigDecimal valor;

	private Long quantidade;

	private ProdutoDTO produto;

	private VendaDTO venda;

}
