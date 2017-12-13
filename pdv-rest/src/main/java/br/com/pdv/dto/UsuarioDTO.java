package br.com.pdv.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends AbstractEntityDTO implements Serializable {

    private static final long serialVersionUID = -6749284348474933705L;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String token;

}