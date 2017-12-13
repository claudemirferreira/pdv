package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.AccountCredentialsDTO;
import br.com.pdv.dto.UsuarioDTO;

public interface UsuarioService {

    public List<UsuarioDTO> findAll();

    public UsuarioDTO save(UsuarioDTO dto);

    public UsuarioDTO update(UsuarioDTO dto);

    public UsuarioDTO findId(Long id);

    public void delete(Long id);

    public UsuarioDTO autenticar(AccountCredentialsDTO dto);
}