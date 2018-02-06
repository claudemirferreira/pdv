package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.AccountCredentialsDTO;
import br.com.pdv.dto.UsuarioDTO;

public interface UsuarioService {

    List<UsuarioDTO> findAll();

    UsuarioDTO save(UsuarioDTO dto);

    UsuarioDTO update(UsuarioDTO dto);

    UsuarioDTO findId(Long id);

    UsuarioDTO findEmail(String email);

    void delete(Long id);

}