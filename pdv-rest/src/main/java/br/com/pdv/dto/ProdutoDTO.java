package br.com.pdv.dto;

import br.com.pdv.enumerated.UnidadeMedidaEnum;
import br.com.pdv.model.entity.Produto;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@JsonRootName("produto")
public class ProdutoDTO implements Serializable {

	@Getter
	@Setter
	@Column(name = "id")
	private long id;

	@Getter
	@Setter
	@Column(name = "nome")
	private String nome;

	@Getter
	@Setter
	@Column(name = "codigoBarra")
	private String codigoBarra;

	@Getter
	@Setter
	@Column(name = "precoCusto")
	private String precoCusto;

	@Getter
	@Setter
	@Column(name = "precoVenda")
	private String precoVenda;

	@Getter
	@Setter
	@Column(name = "estoque")
	private Long estoque;

	@Getter
	@Setter
	@Column(name = "medida")
    @Enumerated(EnumType.ORDINAL)
    private UnidadeMedidaEnum unidadeMedida;

	public ProdutoDTO() {
	}

	public ProdutoDTO(final Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.codigoBarra = produto.getCodigoBarra();
		this.precoCusto = produto.getPrecoCusto().toString();
		this.precoVenda = produto.getPrecoVenda().toString();
		this.estoque = produto.getEstoque();
		this.unidadeMedida = produto.getUnidadeMedida();
	}



}
