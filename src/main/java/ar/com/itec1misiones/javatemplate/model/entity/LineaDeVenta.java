package ar.com.itec1misiones.javatemplate.model.entity;

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
    private int unidad;
    private float precioUnitario;
    private float prectioTotal;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Venta venta;

    public LineaDeVenta(Producto producto, int unidad, float precioUnitario) {
        this.producto = producto;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;

        this.prectioTotal = this.precioUnitario * this.unidad;
    }
}
