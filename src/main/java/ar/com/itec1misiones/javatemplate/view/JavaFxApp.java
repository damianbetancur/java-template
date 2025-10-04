package ar.com.itec1misiones.javatemplate.view;

import ar.com.itec1misiones.javatemplate.SupermarketApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;
import java.util.Objects;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        // Levantamos Spring UNA sola vez. Desactivamos el admin JMX para evitar el choque del MBean.
        this.context = new SpringApplicationBuilder(SupermarketApplication.class)
                .properties("spring.application.admin.enabled=false")
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 1) Intento con el ClassLoader (ruta SIN "/" inicial)
        URL fxmlUrl = Thread.currentThread()
                .getContextClassLoader()
                .getResource("view/cliente.fxml");

        // 2) Fallback con getResource (ruta CON "/" inicial)
        if (fxmlUrl == null) {
            fxmlUrl = JavaFxApp.class.getResource("/view/cliente.fxml");
        }

        if (fxmlUrl == null) {
            String cpRoot = JavaFxApp.class.getProtectionDomain()
                    .getCodeSource().getLocation().toExternalForm();
            throw new IllegalStateException(
                    "No se encontró 'view/controller/inicio.fxml' en el classpath.\n" +
                            "Classpath root: " + cpRoot + "\n" +
                            "Esperado: target/classes/view/controller/inicio.fxml (Maven) o build/resources/main/... (Gradle)."
            );
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        loader.setControllerFactory(context::getBean); // si usás controllers Spring
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        if (context != null) {
            context.close();
        }
    }
}
