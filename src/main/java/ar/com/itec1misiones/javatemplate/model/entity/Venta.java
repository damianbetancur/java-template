package ar.com.itec1misiones.javatemplate.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fecha;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Empleado empleado;

    @OneToMany
    private List<LineaDeVenta> lineaDeVentas = new ArrayList<>();

    public Venta(String fecha, Cliente cliente, Empleado empleado) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public void agregarLineaDeVenta(LineaDeVenta lineaDeVenta){
        this.lineaDeVentas.add(lineaDeVenta);
    }
}
