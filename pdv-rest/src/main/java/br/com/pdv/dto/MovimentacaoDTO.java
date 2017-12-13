package br.com.pdv.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.pdv.enumerated.TipoMovimentacaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private LocalDate data;

	@Getter
	@Setter
	private String numeroNotaFiscal;

	@Getter
	@Setter
	private String obs;

	@Getter
	@Setter
	private TipoMovimentacaoEnum tipoMovimentacao;

}