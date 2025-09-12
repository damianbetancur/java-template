package ar.com.itec1misiones.javatemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String descripcion;
    private Proveedor proveedor;
}
