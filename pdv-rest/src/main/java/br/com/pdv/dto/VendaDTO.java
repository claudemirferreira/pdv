package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.pdv.model.entity.Caixa;
import br.com.pdv.model.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private LocalDate data;

	@Getter
	@Setter
	private BigDecimal total;

	@Getter
	@Setter
	private BigDecimal descontos;

	@Getter
	@Setter
	private Caixa caixa;

	@Getter
	@Setter
	private Cliente cliente;

}
