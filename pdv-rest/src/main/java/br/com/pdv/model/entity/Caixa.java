package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.pdv.enumerated.StatusCaixaEnum;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_caixa")
public class Caixa implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "caixa_id")
	@Getter
	@Setter
	private long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private LocalDate dataAbertura;

	@Column(nullable = false)
	@Getter
	@Setter
	private LocalDate dataFechamento;

	@Column(columnDefinition = "DECIMAL(10,2)")
	@Getter
	@Setter
	private BigDecimal totalFechamento;

	@Column(columnDefinition = "DECIMAL(10,2)")
	@Getter
	@Setter
	private BigDecimal totalApurado;

	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
	@Getter
	@Setter
	private BigDecimal totalInicial;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	@Getter
	@Setter
	private StatusCaixaEnum statusCaixa;

	@OneToMany
	@JoinColumn(name = "caixa_id")
	private List<Sangria> sangrias;

}