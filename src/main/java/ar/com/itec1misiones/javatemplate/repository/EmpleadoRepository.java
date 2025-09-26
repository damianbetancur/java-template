package ar.com.itec1misiones.javatemplate.repository;

import ar.com.itec1misiones.javatemplate.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
