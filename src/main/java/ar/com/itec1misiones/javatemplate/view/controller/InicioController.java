package ar.com.itec1misiones.javatemplate.view.controller;

import ar.com.itec1misiones.javatemplate.config.AppContextProvider;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InicioController {

    @Autowired
    private ApplicationContext context;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private void onClientes() {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Cliente.fxml"));

            // Indicarle a FXMLLoader que use los beans de Spring para crear los controladores
            loader.setControllerFactory(AppContextProvider.getContext()::getBean);

            // Cargar el layout
            AnchorPane clientePane = loader.load();

            // Mostrarlo donde corresponda (por ejemplo, en tu contenedor principal)
            mainContent.getChildren().setAll(clientePane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
