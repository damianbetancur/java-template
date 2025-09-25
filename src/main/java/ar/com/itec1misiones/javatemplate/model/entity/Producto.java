package ar.com.itec1misiones.javatemplate.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private float precioUnitario;

    @ManyToOne
    private Proveedor proveedor;
}
