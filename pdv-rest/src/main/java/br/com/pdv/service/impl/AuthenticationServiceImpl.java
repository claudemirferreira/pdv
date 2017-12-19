package br.com.pdv.service.impl;

import br.com.pdv.dto.UserSecurityDTO;
import br.com.pdv.model.entity.Usuario;
import br.com.pdv.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl  {

    @Autowired
    private UsuarioRepository userRepository;

    public Optional<UserSecurityDTO> authentication(final String email, final String password) {
        final Optional<Usuario> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            if(user.get().getPassword().equals(password)) {
                Optional<UserSecurityDTO> vo = user.map(UserSecurityDTO::new);
                return vo;
            }
        }

        return Optional.empty();
    }

}
