package br.com.pdv.controller.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoFilter implements Serializable {

    private String nome;
    private String codigoBarra;


}
