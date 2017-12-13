package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SangriaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -4034705029885455127L;
	
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private LocalDate data;

	@Getter
	@Setter
	private BigDecimal valor;

	@Getter
	@Setter
	private String obs;

	@Getter
	@Setter
	private CaixaDTO caixa;

}
