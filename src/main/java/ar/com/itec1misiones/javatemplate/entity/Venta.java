package ar.com.itec1misiones.javatemplate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    private LocalDate fecha;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Empleado empleado;

    @OneToMany
    private List<LineaDeVenta> lineaDeVentas = new ArrayList<>();


}
