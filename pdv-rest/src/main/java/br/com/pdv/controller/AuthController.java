package br.com.pdv.controller;

import br.com.pdv.controller.exception.InvalidRequestException;
import br.com.pdv.controller.param.LoginParam;
import br.com.pdv.model.entity.Usuario;
import br.com.pdv.security.UserWithToken;
import br.com.pdv.service.EncryptService;
import br.com.pdv.service.JwtService;
import br.com.pdv.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
public class AuthController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private JwtService jwtService;


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity userLogin(@Valid @RequestBody LoginParam loginParam, BindingResult bindingResult) {
        Optional<Usuario> usuario = service.findUserByEmail(loginParam.getEmail());
        if (usuario.isPresent() && encryptService.check(loginParam.getPassword(), loginParam.getPassword())) {
            return ResponseEntity.ok(userResponse(new UserWithToken(usuario.get(), jwtService.toToken(usuario.get()))));
        } else {
            bindingResult.rejectValue("password", "INVALID", "invalid email or password");
            throw new InvalidRequestException(bindingResult);
        }
    }

    private Map<String, Object> userResponse(UserWithToken userWithToken) {
        return new HashMap() {{
            put("user", userWithToken);
        }};
    }

}
