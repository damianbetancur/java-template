package ar.com.itec1misiones.javatemplate.service.impl;

import ar.com.itec1misiones.javatemplate.entity.Empleado;
import ar.com.itec1misiones.javatemplate.service.EmpleadoService;

import java.util.List;

public class EmpleadoServiceImpl implements EmpleadoService {
    @Override
    public List<Empleado> findAll() {
        return List.of();
    }

    @Override
    public Empleado findOne(Integer id) {
        return null;
    }

    @Override
    public void create(Empleado empleado) {

    }

    @Override
    public void update(Empleado empleado) {

    }

    @Override
    public void delete(Empleado empleado) {

    }
}
