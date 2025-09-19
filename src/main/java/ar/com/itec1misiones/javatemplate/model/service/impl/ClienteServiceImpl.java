package ar.com.itec1misiones.javatemplate.model.service.impl;

import ar.com.itec1misiones.javatemplate.model.entity.Cliente;
import ar.com.itec1misiones.javatemplate.model.service.ClienteService;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    @Override
    public List<Cliente> findAll() {
        return List.of();
    }

    @Override
    public Cliente findOne(Integer id) {
        return null;
    }

    @Override
    public void create(Cliente cliente) {

    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(Cliente cliente) {

    }
}
