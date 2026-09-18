package ar.com.itec1misiones.javatemplate.view.controller;

import ar.com.itec1misiones.javatemplate.controller.ClienteController;
import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import ar.com.itec1misiones.javatemplate.entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteControllerView {
    private final ClienteController controller;
    @FXML private TextField nombre_tfl;
    @FXML private TextField apellido_tfl;
    @FXML private TextField dni_tfl;
    @FXML private TableView<ClienteDTO> tableViewCliente;
    @FXML private TableColumn<ClienteDTO, Integer> numero_tc;
    @FXML private TableColumn<ClienteDTO, String> dni_tc;
    @FXML private TableColumn<ClienteDTO, String> nombre_tc;
    @FXML private TableColumn<ClienteDTO, String> apellido_tc;
    @FXML private Button buscar_btn;
    @FXML private Button aceptar_btn;
    @FXML private Button cancelar_btn;

    private ObservableList<ClienteDTO> clientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Asociar columnas con los getters del modelo
        numero_tc.setCellValueFactory(new PropertyValueFactory<>("Nº"));
        dni_tc.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombre_tc.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        apellido_tc.setCellValueFactory(new PropertyValueFactory<>("Apellido"));

        // Inhabilitar campos
        nombre_tfl.setEditable(false);
        apellido_tfl.setEditable(false);
        dni_tfl.setEditable(false);

        aceptar_btn.setDisable(true);
        cancelar_btn.setDisable(true);

        // Configurar tamaño automático
        if (tableViewCliente != null)
            tableViewCliente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        if (tableViewCliente != null)
            tableViewCliente.setItems(clientes);
    }

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

        ClienteDTO  cliente =  ClienteDTO.builder()
                .nombre(nombre)
                .apellido(apellido)
                .dni(dni)
                .build();
        

        try {
            this.controller.createClient(cliente);
            this.mostrarMensaje("Alerta","Cliente guardado correctamente");
            this.limpiarCampos();
        }catch (Exception ex) {
            this.mostrarMensaje("Error", ex.getMessage());
        }

        aceptar_btn.setDisable(true);
        cancelar_btn.setDisable(true);

        nombre_tfl.setEditable(false);
        apellido_tfl.setEditable(false);
        dni_tfl.setEditable(false);
    }

    @FXML
    public void onCancelar(ActionEvent e) {

    }
}
