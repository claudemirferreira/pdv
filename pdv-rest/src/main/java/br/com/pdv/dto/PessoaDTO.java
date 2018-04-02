package br.com.pdv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonRootName("pessoa")
public class PessoaDTO implements Serializable {

    private String nome;

    public PessoaDTO(String nome) {
        this.nome = nome;
    }

    public PessoaDTO() {
    }
}