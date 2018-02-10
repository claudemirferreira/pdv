package br.com.pdv.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import br.com.pdv.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.UsuarioConvert;
import br.com.pdv.dto.AccountCredentialsDTO;
import br.com.pdv.dto.UsuarioDTO;
import br.com.pdv.model.dao.UsuarioDAO;
import br.com.pdv.model.entity.Usuario;
import br.com.pdv.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConvert convert;



    @Override
    public List<UsuarioDTO> findAll() {
        return convert.convertToDTO(dao.findAll());
    }

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario entity = dao.save(convert.convertToEntity(dto));
        return convert.convertToDTO(entity);
    }

    @Override
    public UsuarioDTO findId(Long id) {
        return convert.convertToDTO(dao.findId(id));
    }

    @Override
    public void delete(Long id) {
        dao.remove(id);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO dto) {
        Usuario entity = dao.update(convert.convertToEntity(dto));
        return convert.convertToDTO(entity);
    }

    @Override
    public UsuarioDTO findUserByEmailConverter(String email) {
        final Optional<Usuario> user = usuarioRepository.findByEmail(email);
        if(user.isPresent()) {
            return convert.convertToDTO(user.get());
        }
        return null;
    }

    @Override
    public Optional<Usuario> findUserByEmail(String email) {
        final Optional<Usuario> user = usuarioRepository.findByEmail(email);
        return user;
    }
}