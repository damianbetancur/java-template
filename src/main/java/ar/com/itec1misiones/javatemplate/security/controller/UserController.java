package ar.com.itec1misiones.javatemplate.security.controller;

import ar.com.itec1misiones.javatemplate.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserController {

    private final LoginService loginService;

    public String login(String user, String password) {
        if (this.loginService.login(user, password)) {
            return "Login realizado com sucesso";
        }
        else {
            return "Usuario o Password invalido";
        }
    }
}
