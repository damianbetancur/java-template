package ar.com.itec1misiones.javatemplate.service;

import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import ar.com.itec1misiones.javatemplate.entity.Cliente;

import java.util.List;

public interface ClienteService extends CRUDService<ClienteDTO> {
    List<Cliente> findByDniStartingWith(String dni);
}
