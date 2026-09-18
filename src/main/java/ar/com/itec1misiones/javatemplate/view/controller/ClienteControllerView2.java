package ar.com.itec1misiones.javatemplate.view.controller;

import ar.com.itec1misiones.javatemplate.controller.ClienteController;
import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import ar.com.itec1misiones.javatemplate.entity.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteControllerView2 {
    private final ClienteController controller;
    @FXML private TableView<ClienteDTO> tableView;
    @FXML private TableColumn<ClienteDTO, Integer> nro;
    @FXML private TableColumn<ClienteDTO, String> dni;
    @FXML private TableColumn<ClienteDTO, String> nombre;
    @FXML private TableColumn<ClienteDTO, String> apellido;

    private ObservableList<ClienteDTO> clientes = FXCollections.observableArrayList();

    public ClienteControllerView2(ClienteController controller) {
        this.controller = controller;
    }

    @FXML
    public void initialize() {
        // Asociar columnas con los getters del modelo
        nro.setCellValueFactory(new PropertyValueFactory<>("nro"));
        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        // Configurar tamaño automático
        if (tableView != null)
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        if (tableView != null)
            tableView.setItems(clientes);
    }

    @FXML
    public void findAll() {
        // Supongamos que tu servicio devuelve un List<ClienteDTO>
        List<ClienteDTO> clientes = controller.findAll();

        // Convertir la lista normal a una lista observable
        tableView.setItems(FXCollections.observableArrayList(clientes));
    }
}
