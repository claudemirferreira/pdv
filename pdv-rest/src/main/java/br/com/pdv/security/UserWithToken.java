package br.com.pdv.security;

import br.com.pdv.model.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserWithToken implements Serializable {

    private String email;
    private String userName;
    private String token;
    private String image;

    public UserWithToken(Usuario usuario, String token) {
        this.email = usuario.getEmail();
        this.userName = usuario.getUsername();
        this.token = token;
    }
}
