package br.com.pdv.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "saa_usuario")
public class Usuario extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 3291494144974734307L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 20)
    @Getter
    @Setter
    private String firstName;

    @Column(nullable = false, length = 20)
    @Getter
    @Setter
    private String lastName;

    @Column(nullable = false, length = 20)
    @Getter
    @Setter
    private String userName;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    @Email
    private String email;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String password;

    @Column(length = 100)
    @Getter
    @Setter
    private String token;

    public Usuario() {

    }

    public Usuario(Long id, String firstName, String lastName, String userName, String email, String password, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.token = token;
    }

}