package ar.com.itec1misiones.javatemplate.view.controller;

import ar.com.itec1misiones.javatemplate.service.LoginService;
import ar.com.itec1misiones.javatemplate.view.JavaFxApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    private final LoginService loginService;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label mensajeLabel;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @FXML
    private void initialize() {
        if (mensajeLabel != null) {
            mensajeLabel.setText("Ingrese sus credenciales");
        }
    }

    @FXML
    private void onLogin(ActionEvent event) {
        String usuario = usuarioField != null ? usuarioField.getText() : "";
        String password = passwordField != null ? passwordField.getText() : "";

        if (usuario == null || usuario.isBlank() || password == null || password.isBlank()) {
            if (mensajeLabel != null) {
                mensajeLabel.setText("El usuario y la contraseña son obligatorios");
            }
            return;
        }

        boolean autenticado = loginService.autenticar(usuario.trim(), password);

        if (autenticado) {
            if (mensajeLabel != null) {
                mensajeLabel.setText("Login correcto");
            }
            JavaFxApp.showScene("view/inicio.fxml", "Inicio");
        } else {
            if (mensajeLabel != null) {
                mensajeLabel.setText("Usuario o contraseña incorrectos");
            }
        }
    }
}

