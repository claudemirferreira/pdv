package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.pdv.enumerated.StatusCaixaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaixaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private LocalDate dataAbertura;

	@Getter
	@Setter
	private LocalDate dataFechamento;

	@Getter
	@Setter
	private BigDecimal totalFechamento;

	@Getter
	@Setter
	private BigDecimal totalApurado;

	@Getter
	@Setter
	private BigDecimal totalInicial;

	@Getter
	@Setter
	private StatusCaixaEnum statusCaixa;

	@Getter
	@Setter
	private List<SangriaDTO> sangrias;

}
