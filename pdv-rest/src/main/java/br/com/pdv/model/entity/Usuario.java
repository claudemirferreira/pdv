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
    private Long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 100)
    @Email
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 100)
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

    public String getEmail() {
        return this.email;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialNonExpired() {
        return credentialNonExpired;
    }

    public void setCredentialNonExpired(boolean credentialNonExpired) {
        this.credentialNonExpired = credentialNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}