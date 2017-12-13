package br.com.pdv.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String endereco;

	@Getter
	@Setter
	private String cpf;

	@Getter
	@Setter
	private String telefone;

	@Getter
	@Setter
	private LocalDate dataNascimento;

}
