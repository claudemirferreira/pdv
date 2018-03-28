package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.pdv.model.entity.Caixa;
import br.com.pdv.model.entity.Cliente;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("venda")
public class VendaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private Long id;

	private Date data;

	private BigDecimal total;

	private BigDecimal descontos;

	private CaixaDTO caixa;

	private ClienteDTO cliente;

	private List<ProdutoVendaDTO> produtoVendas;

}