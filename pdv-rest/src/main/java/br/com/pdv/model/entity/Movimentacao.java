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
public class Movimentacao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movimentacao_id")
	@Getter
	@Setter
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public TipoMovimentacaoEnum getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacaoEnum tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	
}