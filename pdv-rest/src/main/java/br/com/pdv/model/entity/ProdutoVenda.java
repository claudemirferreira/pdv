package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_produto_venda")
@Getter
@Setter
public class ProdutoVenda extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_vend_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda venda;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal valor;

	@Column(length = 100)
	private Long quantidade;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;



}