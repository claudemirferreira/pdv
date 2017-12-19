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
@Getter
@Setter
public class Movimentacao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movimentacao_id")
	private Long id;

	@Column(nullable = false)
	private LocalDate data;

	@Column(length = 15)
	private String numeroNotaFiscal;


	@Column(length = 100)
	private String obs;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)	
	private TipoMovimentacaoEnum tipoMovimentacao;

	public Movimentacao(LocalDate data, String numeroNotaFiscal, String obs,
			TipoMovimentacaoEnum tipoMovimentacao) {
		super();
		this.data = data;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.obs = obs;
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Movimentacao() {
	}
	
}