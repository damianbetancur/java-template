package ar.com.itec1misiones.javatemplate.view.controller;

import ar.com.itec1misiones.javatemplate.controller.ClienteController;
import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class ClienteControllerView {
    private final ClienteController controller;
    @FXML private TextField nombre_tfl;
    @FXML private TextField apellido_tfl;
    @FXML private TextField dni_tfl;

    public ClienteControllerView(ClienteController controller) {
        this.controller = controller;
    }

    // Funcion para mostrar alerta
    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Funcion para limpiar los campos
    private void limpiarCampos(){
        nombre_tfl.clear();
        apellido_tfl.clear();
        dni_tfl.clear();
    }


    // Funcion para guardar un nuevo dato en la base de datos usando el ClienteController
    @FXML
    public void onGuardar(ActionEvent e) {
        String nombre = nombre_tfl.getText();
        String apellido = apellido_tfl.getText();
        String dni = dni_tfl.getText();

        ClienteDTO  cliente = new ClienteDTO();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);

        try {
            this.controller.createClient(cliente);
            this.mostrarMensaje("Alerta","Cliente guardado correctamente");
            this.limpiarCampos();
        }catch (Exception ex) {
            this.mostrarMensaje("Error", ex.getMessage());
        }


    }

    @FXML
    public void onAgregar(ActionEvent e) {
        String nombre = nombre_tfl.getText();
        String apellido = apellido_tfl.getText();
        String dni = dni_tfl.getText();

        ClienteDTO  cliente = new ClienteDTO();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);

        try {
            this.controller.createClient(cliente);
            this.mostrarMensaje("Alerta","Cliente guardado correctamente");
            this.limpiarCampos();
        }catch (Exception ex) {
            this.mostrarMensaje("Error", ex.getMessage());
        }
    }

    @FXML
    public void onModificar(ActionEvent e) {

    }

    @FXML
    public void onEliminar(ActionEvent e) {

    }

    @FXML
    public void onBuscar(ActionEvent e) {

    }

    @FXML
    public void onSelected(ActionEvent e) {

    }
}
