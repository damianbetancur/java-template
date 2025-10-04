package ar.com.itec1misiones.javatemplate.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "lineas_de_ventas")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineaDeVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int cantidad;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Venta venta;


}
