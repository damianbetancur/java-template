package ar.com.itec1misiones.javatemplate;

import ar.com.itec1misiones.javatemplate.controller.ClienteController;
import ar.com.itec1misiones.javatemplate.view.JavaFxApp;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupermarketApplication {

    public static void main(String[] args) {

        SpringApplication.run(SupermarketApplication.class, args);
        Application.launch(JavaFxApp.class, args);


    }

}
