package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "pdv_produto_venda")
public class ProdutoVenda extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_vend_id")
	@Getter
	@Setter
	private Long id;

	@Column(columnDefinition = "DECIMAL(10,2)")
	@Getter
	@Setter
	private BigDecimal valor;

	@Getter
	@Setter
	@Column(length = 100)
	private Long quantidade;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda venda;

}