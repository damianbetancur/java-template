package ar.com.itec1misiones.javatemplate.view;


import ar.com.itec1misiones.javatemplate.SupermarketApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        // Arranca Spring (una sola vez) antes de mostrar la UI
        this.context = SpringApplication.run(SupermarketApplication.class);
    }

    @Override
    public void start(Stage primaryStage) {
        // UI mínima (primer paso)
        Label hello = new Label("¡JavaFX + Spring OK!");
        Scene scene = new Scene(hello, 420, 160);

        primaryStage.setTitle("Demo Spring + JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Cierre ordenado
        if (context != null) context.close();
        Platform.exit();
    }

    // (Opcional) expone el contexto si más adelante querés inyectar en controllers
    public ConfigurableApplicationContext getContext() {
        return context;
    }
}
