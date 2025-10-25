package ar.com.itec1misiones.javatemplate.service.impl;

import ar.com.itec1misiones.javatemplate.dto.ClienteDTO;
import ar.com.itec1misiones.javatemplate.entity.Cliente;
import ar.com.itec1misiones.javatemplate.repository.ClienteRepository;
import ar.com.itec1misiones.javatemplate.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteDTO> clientesResultados = new ArrayList<>();
        for(Cliente clienteRecorrido: clienteRepository.findAll()){
            clientesResultados.add(ClienteDTO.builder()
                    .dni(clienteRecorrido.getDni())
                    .nombre(clienteRecorrido.getNombre())
                    .apellido(clienteRecorrido.getApellido())
                    .build());
        }
        return clientesResultados;
    }

    @Override
    public ClienteDTO findOne(Integer id) {
        return null;
    }

    @Override
    public void create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDni(clienteDTO.getDni());

        clienteRepository.save(cliente);
    }

    @Override
    public void update(ClienteDTO clienteDTO) {

    }

    @Override
    public void delete(ClienteDTO clienteDTO) {

    }


    @Override
    public List<Cliente> findByDniStartingWith(String dni) {
        return clienteRepository.findByDniStartingWith(dni);
    }
}
