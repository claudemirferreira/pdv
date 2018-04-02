package br.com.pdv.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_sangria")
@Getter
@Setter
public class Sangria extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sangria_id")
	private Long id;

	@NotNull
	@Column(columnDefinition= "TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal valor;

	@Column(length = 100)
	private String obs;

	@ManyToOne
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;

}