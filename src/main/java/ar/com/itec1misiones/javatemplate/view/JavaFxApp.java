package ar.com.itec1misiones.javatemplate.view;

import ar.com.itec1misiones.javatemplate.SupermarketApplication;
import ar.com.itec1misiones.javatemplate.controller.ClienteController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext context;
    private Scene escenaPrincipal;

    @Override
    public void init() {
        this.context = new SpringApplicationBuilder(SupermarketApplication.class)
                .headless(false)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) {
        Button btnNuevo = new Button("Crear Cliente");
        btnNuevo.setOnAction(e -> {
            ClienteController controller = context.getBean(ClienteController.class);
            CrearClienteScene crear = new CrearClienteScene(
                    primaryStage,
                    controller,
                    () -> { primaryStage.setScene(escenaPrincipal); primaryStage.centerOnScreen(); }
            );
            primaryStage.setScene(crear.getScene());
            primaryStage.centerOnScreen();
        });

        VBox root = new VBox(15, new Label("Menú Principal"), btnNuevo);
        escenaPrincipal = new Scene(root, 320, 200);

        primaryStage.setTitle("Gestión de Clientes");
        primaryStage.setScene(escenaPrincipal);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    @Override
    public void stop() {
        if (context != null) context.close();
        Platform.exit();
    }

    public ConfigurableApplicationContext getContext() { return context; }
}
