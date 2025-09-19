package ar.com.itec1misiones.javatemplate.model.service.impl;

import ar.com.itec1misiones.javatemplate.model.entity.Venta;
import ar.com.itec1misiones.javatemplate.model.service.VentaService;

import java.util.List;

public class VentaServiceImpl implements VentaService {
    @Override
    public List<Venta> findAll() {
        return List.of();
    }

    @Override
    public Venta findOne(Integer id) {
        return null;
    }

    @Override
    public void create(Venta venta) {

    }

    @Override
    public void update(Venta venta) {

    }

    @Override
    public void delete(Venta venta) {

    }
}
