package ar.com.itec1misiones.javatemplate.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class InicioController {

    @FXML private TextField dniField;
    @FXML private TextField nombreField;
    @FXML private TextField apellidoField;
    @FXML private Label estadoLabel;
    @FXML private Button aceptarBtn;

    @FXML
    public void initialize() {
        if (estadoLabel != null) {
            estadoLabel.setText("Listo");
        }
    }

    @FXML
    private void onAceptar(ActionEvent e) {
        String dni = dniField != null ? dniField.getText() : "";
        String nombre = nombreField != null ? nombreField.getText() : "";
        String apellido = apellidoField != null ? apellidoField.getText() : "";
        if (estadoLabel != null) {
            estadoLabel.setText("OK: " + dni + " - " + nombre + " " + apellido);
        }
        // Aquí podés inyectar servicios Spring y ejecutar lógica de negocio.
    }
}
