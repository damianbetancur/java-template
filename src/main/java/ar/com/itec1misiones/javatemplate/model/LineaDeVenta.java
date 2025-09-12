package ar.com.itec1misiones.javatemplate.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class LineaDeVenta {
    private int unidad;
    private float precioUnitario;
    private float prectioTotal;
    private Producto producto;
    private Venta venta;

    public LineaDeVenta(Producto producto, int unidad, float precioUnitario) {
        this.producto = producto;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;

        this.prectioTotal = this.precioUnitario * this.unidad;
    }
}
