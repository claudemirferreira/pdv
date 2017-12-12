package br.com.pdv.model.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.pdv.dto.AccountCredentialsDTO;
import br.com.pdv.model.entity.Usuario;

@Repository
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario autenticar(AccountCredentialsDTO dto) {
        try {
            return (Usuario) em.createQuery("SELECT u from Usuario u where u.userName = :userName and u.password = :password").setParameter("userName", dto.getUserName())
                    .setParameter("password", dto.getPassword()).getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }
}