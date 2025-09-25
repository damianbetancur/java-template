package ar.com.itec1misiones.javatemplate.model.repository;

import ar.com.itec1misiones.javatemplate.model.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
