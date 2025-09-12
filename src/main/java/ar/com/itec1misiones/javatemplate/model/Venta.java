package ar.com.itec1misiones.javatemplate.model;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Venta {
    private String fecha;
    private Cliente cliente;
    private Empleado empleado;
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
