package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.pdv.model.entity.Produto;
import br.com.pdv.model.entity.Venda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoVendaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private BigDecimal valor;

	@Getter
	@Setter
	private Long quantidade;

	@Getter
	@Setter
	private Produto produto;

	@Getter
	@Setter
	private Venda venda;

}
