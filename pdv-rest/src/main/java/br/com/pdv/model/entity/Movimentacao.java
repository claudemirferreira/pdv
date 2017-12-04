package br.com.pdv.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.pdv.enumerated.TipoMovimentacaoEnum;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_movimentacao")
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movimentacao_id")
	@Getter
	@Setter
	private long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private LocalDate data;

	@Getter
	@Setter
	@Column(length = 15)
	private String numeroNotaFiscal;

	@Getter
	@Setter
	@Column(length = 100)
	private String obs;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	@Getter
	@Setter
	private TipoMovimentacaoEnum tipoMovimentacao;

}