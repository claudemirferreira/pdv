package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.pdv.enumerated.UnidadeMedidaEnum;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_produto")
public class Produto extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produto_id")
	@Getter
	@Setter
	private Long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String codigoBarra;

	@Column(columnDefinition = "DECIMAL(10,2)")
	@Getter
	@Setter
	private BigDecimal precoCusto;

	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
	@Getter
	@Setter
	private BigDecimal precoVenda;

	@Getter
	@Setter
	private Long estoque;

	@Enumerated(EnumType.ORDINAL)
	private UnidadeMedidaEnum unidadeMedida;

	public Produto() {
	}

	public Produto(Long id, String nome, String codigoBarra, BigDecimal precoCusto, BigDecimal precoVenda, Long estoque,
			UnidadeMedidaEnum unidadeMedida) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoBarra = codigoBarra;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.estoque = estoque;
		this.unidadeMedida = unidadeMedida;
	}

	public Produto(String nome, String codigoBarra, BigDecimal precoCusto, BigDecimal precoVenda, Long estoque,
			UnidadeMedidaEnum unidadeMedida) {
		this.nome = nome;
		this.codigoBarra = codigoBarra;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.estoque = estoque;
		this.unidadeMedida = unidadeMedida;
	}

	public Long getId() {
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