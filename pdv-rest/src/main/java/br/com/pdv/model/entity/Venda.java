package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_venda")
@Getter
@Setter
public class Venda extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "venda_id")
	private Long id;

	@OneToMany(mappedBy = "venda")
	private List<ProdutoVenda> produtoVendas;

	@Column(nullable = false)
	private Date data;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal total;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal descontos;

	@ManyToOne
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}