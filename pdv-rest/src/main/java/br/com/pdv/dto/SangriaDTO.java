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

	private LocalDate data;

	private BigDecimal valor;

	private String obs;

	private CaixaDTO caixa;

}
