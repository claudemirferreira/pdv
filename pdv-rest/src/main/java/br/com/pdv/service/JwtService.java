package br.com.pdv.service;

import br.com.pdv.model.entity.Usuario;

import java.util.Optional;

public interface JwtService {

    String toToken(Usuario user);

    Optional<String> getSubFromToken(String token);

}
