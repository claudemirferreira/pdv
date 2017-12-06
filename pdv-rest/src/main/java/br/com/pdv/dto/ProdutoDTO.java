package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pdv.enumerated.UnidadeMedidaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1249522011011892391L;

	private long id;

	@Column(name = "nome")
	private String nome;

	private String codigoBarra;

	private BigDecimal precoCusto;

	private BigDecimal precoVenda;

	private Long estoque;

	@Enumerated(EnumType.ORDINAL)
	private UnidadeMedidaEnum unidadeMedida;

}
