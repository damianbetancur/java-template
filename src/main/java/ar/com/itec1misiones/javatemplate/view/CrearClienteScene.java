package ar.com.itec1misiones.javatemplate.view;

import ar.com.itec1misiones.javatemplate.controller.ClienteController;
import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CrearClienteScene {

    private final Scene scene;

    public CrearClienteScene(Stage stage, ClienteController clienteController, Runnable onVolver) {

        Label lblDni = new Label("DNI:");
        TextField txtDni = new TextField();

        Label lblNombre = new Label("Nombre:");
        TextField txtNombre = new TextField();

        Label lblApellido = new Label("Apellido:");
        TextField txtApellido = new TextField();

        Button btnGuardar = new Button("Guardar");
        Button btnVolver = new Button("Volver");

        btnGuardar.setOnAction(e -> {
            try {
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setDni(txtDni.getText());
                clienteDTO.setNombre(txtNombre.getText());
                clienteDTO.setApellido(txtApellido.getText());

                clienteController.createClient(clienteDTO);

                txtDni.clear();
                txtNombre.clear();
                txtApellido.clear();
            } catch (Exception ex) {
                mostrarError("No se pudo crear el cliente", ex.getMessage());
            }
        });

        btnVolver.setOnAction(e -> onVolver.run());

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.add(lblDni, 0, 0);
        grid.add(txtDni, 1, 0);
        grid.add(lblNombre, 0, 1);
        grid.add(txtNombre, 1, 1);
        grid.add(lblApellido, 0, 2);
        grid.add(txtApellido, 1, 2);
        grid.add(btnGuardar, 0, 3);
        grid.add(btnVolver, 1, 3);

        this.scene = new Scene(grid, 420, 240);
    }

    public Scene getScene() {
        return scene;
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
}
