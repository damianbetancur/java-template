package ar.com.itec1misiones.javatemplate.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String dni;
}
