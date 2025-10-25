package ar.com.itec1misiones.javatemplate.view.controller;

import ar.com.itec1misiones.javatemplate.security.controller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext; // Necesitarás Spring Context
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginControllerView {
    private final LoginController controller;
    private final ApplicationContext applicationContext; // 💡 Nuevo: Para cargar el controlador de Spring

    @FXML private TextField user_tfl;
    @FXML private PasswordField password_pfl;
    @FXML private Button login_btn;
    @FXML private Label message_lbl;

    // 💡 Modificación: Inyectar ApplicationContext para obtener el controlador de la vista de inicio
    public LoginControllerView(LoginController controller, ApplicationContext applicationContext) {
        this.controller = controller;
        this.applicationContext = applicationContext;
    }

    @FXML
    public void login() {
        String result = this.controller.login(user_tfl.getText(), password_pfl.getText());
        message_lbl.setText(result);

        // 1. Verificar si el login fue exitoso (Ajusta la condición según tu lógica)
        // ASUMO que si 'result' no contiene la palabra "Error", el login fue exitoso.
        if (result != null && !result.contains("Error")) {

            // 2. Cerrar la ventana de Login
            Stage currentStage = (Stage) login_btn.getScene().getWindow();
            currentStage.close();

            // 3. Abrir la nueva ventana (Vista de Inicio)
            try {
                // 3.1 Cargar el FXML. Usamos un FXMLLoader personalizado para que Spring maneje el controlador
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Inicio.fxml"));

                // 3.2 Establecer el ControllerFactory para que Spring inyecte el controlador (InicioControllerView)
                fxmlLoader.setControllerFactory(applicationContext::getBean);

                Parent root = fxmlLoader.load();

                Stage stage = new Stage();
                stage.setTitle("Sistema - Inicio"); // Título de la nueva ventana
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                // Manejo de error si no se encuentra o no se puede cargar el FXML de Inicio
                e.printStackTrace();
                message_lbl.setText("Error al cargar la vista de inicio.");
                // Opcionalmente: reabrir la ventana de login si falla la carga.

            }
        }
    }
}