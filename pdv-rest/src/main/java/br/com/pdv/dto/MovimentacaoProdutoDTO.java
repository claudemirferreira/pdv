package br.com.pdv.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoProdutoDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = 2373744398302737251L;
	
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private ProdutoDTO produto;

	@Getter
	@Setter
	private long quantidade;

}