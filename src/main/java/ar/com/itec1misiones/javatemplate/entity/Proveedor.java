package ar.com.itec1misiones.javatemplate.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
}
