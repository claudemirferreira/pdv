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

@Getter
@Setter
@JsonRootName("produto")
public class ProdutoDTO implements Serializable {

	@Column(name = "id")
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "codigoBarra")
	private String codigoBarra;

	@Column(name = "precoCusto")
	private String precoCusto;

	@Column(name = "precoVenda")
	private String precoVenda;

	@Column(name = "estoque")
	private Long estoque;

	@Column(name = "medida")
    @Enumerated(EnumType.ORDINAL)
    private UnidadeMedidaEnum unidadeMedida;

	public void setProduto(final Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.codigoBarra = produto.getCodigoBarra();
		this.precoCusto = produto.getPrecoCusto().toString();
		this.precoVenda = produto.getPrecoVenda().toString();
		this.estoque = produto.getEstoque();
		this.unidadeMedida = produto.getUnidadeMedida();
	}

}
