package ar.com.itec1misiones.javatemplate.service.impl;

import ar.com.itec1misiones.javatemplate.entity.Producto;
import ar.com.itec1misiones.javatemplate.service.ProductoService;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> findAll() {
        return List.of();
    }

    @Override
    public Producto findOne(Integer id) {
        return null;
    }

    @Override
    public void create(Producto producto) {

    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(Producto producto) {

    }
}
