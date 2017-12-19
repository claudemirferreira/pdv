package br.com.pdv.service.impl;

import br.com.pdv.dto.UsuarioDTO;
import br.com.pdv.model.entity.Usuario;
import br.com.pdv.model.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UsuarioRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailServiceImpl(UsuarioRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> user =  userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(email);
        }

        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), user.get().getAuthorities());
    }

}
