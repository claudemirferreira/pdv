package br.com.pdv.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import br.com.pdv.enumerated.TipoMovimentacaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private Date data;

	private String numeroNotaFiscal;

	private String obs;

	private TipoMovimentacaoEnum tipoMovimentacao;

	private  UsuarioDTO usuario;
}