package br.com.pdv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import br.com.pdv.enumerated.StatusCaixaEnum;
import br.com.pdv.util.LocalDateDeserializer;
import br.com.pdv.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("caixa")
public class CaixaDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private Date dataAbertura;

	private Date dataFechamento;

	private BigDecimal totalFechamento;

	private BigDecimal totalApurado;

	private BigDecimal totalInicial;

	private StatusCaixaEnum statusCaixa;

	private List<SangriaDTO> sangrias;

	private UsuarioDTO usuario;

    public CaixaDTO() {
    }

    public CaixaDTO(Date dataAbertura, Date dataFechamento, BigDecimal totalFechamento, BigDecimal totalApurado, BigDecimal totalInicial, StatusCaixaEnum statusCaixa, List<SangriaDTO> sangrias) {
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.totalFechamento = totalFechamento;
        this.totalApurado = totalApurado;
        this.totalInicial = totalInicial;
        this.statusCaixa = statusCaixa;
        this.sangrias = sangrias;
    }
}