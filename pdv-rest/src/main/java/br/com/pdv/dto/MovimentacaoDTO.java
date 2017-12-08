package br.com.pdv.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pdv.enumerated.TipoMovimentacaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private LocalDate data;

	private String numeroNotaFiscal;

	private String obs;

	@Enumerated(EnumType.ORDINAL)
	private TipoMovimentacaoEnum tipoMovimentacao;

}