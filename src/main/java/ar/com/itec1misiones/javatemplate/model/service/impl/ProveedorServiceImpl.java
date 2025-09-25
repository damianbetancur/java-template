package ar.com.itec1misiones.javatemplate.model.service.impl;

import ar.com.itec1misiones.javatemplate.model.entity.Proveedor;
import ar.com.itec1misiones.javatemplate.model.service.ProveedorService;

import java.util.List;

public class ProveedorServiceImpl implements ProveedorService {
    @Override
    public List<Proveedor> findAll() {
        return List.of();
    }

    @Override
    public Proveedor findOne(Integer id) {
        return null;
    }

    @Override
    public void create(Proveedor proveedor) {

    }

    @Override
    public void update(Proveedor proveedor) {

    }

    @Override
    public void delete(Proveedor proveedor) {

    }
}
