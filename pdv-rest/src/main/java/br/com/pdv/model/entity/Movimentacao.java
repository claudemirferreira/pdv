package br.com.pdv.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

	@NotNull
	@Column(columnDefinition= "TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(length = 15)
	private String numeroNotaFiscal;

	@Column(length = 100)
	@NotNull
	private String obs;

	@Enumerated(EnumType.ORDINAL)
	@Column
	@NotNull
	private TipoMovimentacaoEnum tipoMovimentacao;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public Movimentacao(Date data, String numeroNotaFiscal, String obs,
			TipoMovimentacaoEnum tipoMovimentacao, Usuario usuario) {
		super();
		this.data = data;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.obs = obs;
		this.tipoMovimentacao = tipoMovimentacao;
		this.usuario = usuario;
	}

	public Movimentacao() {
	}
}