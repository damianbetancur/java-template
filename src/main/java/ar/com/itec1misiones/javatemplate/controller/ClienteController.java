package ar.com.itec1misiones.javatemplate.controller;

import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import ar.com.itec1misiones.javatemplate.service.ClienteService;
import javafx.collections.ObservableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    public void createClient(ClienteDTO clienteDTO){
        clienteService.create(clienteDTO);
    }

    public List<ClienteDTO> findAll(){
        return  clienteService.findAll();
    }

}
