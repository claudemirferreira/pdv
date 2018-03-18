package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "pdv_venda")
@Getter
@Setter
public class Venda extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "venda_id")
	private Long id;

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