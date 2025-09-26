package ar.com.itec1misiones.javatemplate.controller;

import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import ar.com.itec1misiones.javatemplate.entity.Cliente;
import ar.com.itec1misiones.javatemplate.service.ClienteService;

import java.util.List;

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre("Mauro");
        clienteDTO.setApellido("Britez");
        clienteDTO.setDni("12345678");
        createClient(clienteDTO);
    }

    public List<Cliente> findClientByDniStartingWith(String dni){
        return clienteService.findByDniStartingWith(dni);
    }

    public void createClient(ClienteDTO clienteDTO){
        clienteService.create(clienteDTO);
    }
}
