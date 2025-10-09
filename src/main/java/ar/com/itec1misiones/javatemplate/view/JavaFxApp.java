package ar.com.itec1misiones.javatemplate.view;

import ar.com.itec1misiones.javatemplate.SupermarketApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext context; //contexto de spring

    @Override
    public void init() {
        // Levantamos Spring UNA sola vez. Desactivamos el admin JMX para evitar el choque del MBean.
        this.context = new SpringApplicationBuilder(SupermarketApplication.class)
                .properties("spring.application.admin.enabled=false")
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 1) Intenta localizar el archivo cliente.fxml dentro del classpath, usando el ClassLoader, este no usa "/" al inicio de la ruta.
        URL fxmlUrl = Thread.currentThread()
                .getContextClassLoader()
                .getResource("view/cliente.fxml");

        // 2) Si el primer intento falló intenta nuevamente usando Class.getResource. En este caso, la ruta lleva un "/" inicial.
        if (fxmlUrl == null) {
            fxmlUrl = JavaFxApp.class.getResource("/view/cliente.fxml");
        }

        // Si ninguno de los dos intentos anteriores encuentra el archivo, lanza una excepción con un mensaje detallado.
        if (fxmlUrl == null) {
            String cpRoot = JavaFxApp.class.getProtectionDomain()
                    .getCodeSource().getLocation().toExternalForm();
            throw new IllegalStateException(
                    "No se encontró 'view/controller/cliente.fxml' en el classpath.\n" +
                            "Classpath root: " + cpRoot + "\n" +
                            "Esperado: target/classes/view/controller/cliente.fxml (Maven) o build/resources/main/... (Gradle)."
            );
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl); // Crea un FXMLLoader con la URL del archivo encontrado.
        loader.setControllerFactory(context::getBean); // Permite que los controladores del FXML sean gestionados por Spring, para poder usar inyección de dependencias.
        Parent root = loader.load(); // Carga el FXML y genera un árbol de nodos JavaFX (Parent root) que representa la interfaz gráfica.

        Scene scene = new Scene(root); // Crea una nueva Scene usando el root del FXML cargado.
        stage.setTitle("Inicio"); // Establece el título de la ventana.
        stage.setScene(scene); // Asigna la escena al Stage (la ventana principal).
        stage.show(); // Muestra la ventana con show().
    }

    @Override
    public void stop() {
        if (context != null) {
            context.close();
        }
        Platform.exit();
    }
}
