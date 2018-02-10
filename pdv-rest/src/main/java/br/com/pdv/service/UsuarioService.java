package br.com.pdv.service;

import java.util.List;
import java.util.Optional;

import br.com.pdv.dto.AccountCredentialsDTO;
import br.com.pdv.dto.UsuarioDTO;
import br.com.pdv.model.entity.Usuario;

public interface UsuarioService {

    List<UsuarioDTO> findAll();

    UsuarioDTO save(UsuarioDTO dto);

    UsuarioDTO update(UsuarioDTO dto);

    UsuarioDTO findId(Long id);

    UsuarioDTO findUserByEmailConverter(String email);

    Optional<Usuario> findUserByEmail(String email);

    void delete(Long id);

}