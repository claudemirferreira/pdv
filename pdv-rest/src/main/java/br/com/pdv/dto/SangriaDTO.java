package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("sangria")
public class SangriaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -4034705029885455127L;
	
	private Date data;

	private BigDecimal valor;

	private String obs;

	private CaixaDTO caixa;

	public SangriaDTO(){

	}

	public SangriaDTO(Date data, BigDecimal valor, String obs, CaixaDTO caixa) {
		this.data = data;
		this.valor = valor;
		this.obs = obs;
		this.caixa = caixa;
	}
}
