package br.com.pdv.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "saa_usuario")
public class Usuario extends AbstractEntity implements UserDetails, Serializable {

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

    @Column(name = "tx_authorities")
    @NotNull
    private String authorities;

    @Column(name = "bl_account_non_expired")
    @NotNull
    private boolean accountNonExpired;

    @Column(name = "bl_account_non_locket")
    @NotNull
    private boolean accountNonLocked;

    @Column(name = "bl_credential_non_expired")
    @NotNull
    private boolean credentialNonExpired;

    @Column(name = "bl_enabled")
    @NotNull
    private boolean enabled;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<String> authList = Arrays.asList(this.authorities.split(":"));
        final List<Authority> auths = new ArrayList<>();
        authList.stream().forEach(s -> {
            auths.add(new Authority(s));
        });
        return auths;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}