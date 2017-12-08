package br.com.pdv.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO extends AbstractEntityDTO implements Serializable {

	private static final long serialVersionUID = -6749284348474933705L;

	private String nome;

	private String endereco;

	private String cpf;

	private String telefone;

	private LocalDate dataNascimento;

}
