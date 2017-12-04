package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pdv.enumerated.UnidadeMedidaEnum;
import lombok.Getter;
import lombok.Setter;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1249522011011892391L;

	@Getter
	@Setter
	private long id;

	@Column(name = "nome")
	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String codigoBarra;

	@Getter
	@Setter
	private BigDecimal precoCusto;

	@Getter
	@Setter
	private BigDecimal precoVenda;

	@Getter
	@Setter
	private Long estoque;

	@Enumerated(EnumType.ORDINAL)
	private UnidadeMedidaEnum unidadeMedida;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public UnidadeMedidaEnum getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedidaEnum unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

}
