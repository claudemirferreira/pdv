package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pdv.enumerated.StatusCaixaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaixaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private LocalDate dataAbertura;

	private LocalDate dataFechamento;

	private BigDecimal totalFechamento;

	private BigDecimal totalApurado;

	private BigDecimal totalInicial;

	@Enumerated(EnumType.ORDINAL)
	private StatusCaixaEnum statusCaixa;

	private List<SangriaDTO> sangrias;

}
