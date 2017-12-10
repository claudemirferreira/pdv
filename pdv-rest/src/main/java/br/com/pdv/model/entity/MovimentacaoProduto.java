package br.com.pdv.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_movimentacao_produto")
public class MovimentacaoProduto extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mov_pro_id")
	@Getter
	@Setter
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@JoinColumn(nullable = false)
	@Getter
	@Setter
	private Long quantidade;

	@ManyToOne
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao movimentacao;
	
	public MovimentacaoProduto() {

	}

	public MovimentacaoProduto(Produto produto, Long quantidade, Movimentacao movimentacao) {
		this.produto = produto;
		this.movimentacao = movimentacao;
		this.quantidade = quantidade;
	}

}