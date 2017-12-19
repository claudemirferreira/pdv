package br.com.pdv.dto;

import br.com.pdv.model.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserSecurityDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String name;

    private String lastName;

    public UserSecurityDTO(String email, String password, String name, String lastName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public UserSecurityDTO(Usuario usuario) {
        this.email = usuario.getEmail();
        this.name = usuario.getFirstName();
        this.lastName = usuario.getLastName();
    }
}
