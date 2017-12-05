package br.com.pdv.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdv_cliente")
public class Cliente extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4203174084588806620L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cliente_id")
	@Getter
	@Setter
	private Long id;

	@Column(nullable = false)
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