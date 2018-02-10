package br.com.pdv.service.impl;

import br.com.pdv.service.EncryptService;
import org.springframework.stereotype.Component;

@Component
public class NativeEncryptService implements EncryptService {

    @Override
    public String encrypt(String password) {
        return password;
    }

    @Override
    public boolean check(String checkPassword, String realPassword) {
        return checkPassword.equals(realPassword);
    }
}
