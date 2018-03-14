package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.pdv.enumerated.StatusCaixaEnum;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_caixa")
@Getter
@Setter
public class Caixa extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "caixa_id")
	private Long id;

	@Column(columnDefinition= "TIMESTAMP WITH TIME ZONE")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;

	@Column(columnDefinition= "TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal totalFechamento;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal totalApurado;

	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)

	private BigDecimal totalInicial;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)

	private StatusCaixaEnum statusCaixa;

	@OneToMany
	@JoinColumn(name = "caixa_id")
	private List<Sangria> sangrias;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
}