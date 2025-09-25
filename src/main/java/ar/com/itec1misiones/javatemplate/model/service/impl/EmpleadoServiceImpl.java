package ar.com.itec1misiones.javatemplate.model.service.impl;

import ar.com.itec1misiones.javatemplate.model.entity.Empleado;
import ar.com.itec1misiones.javatemplate.model.service.EmpleadoService;

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
