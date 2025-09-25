package ar.com.itec1misiones.javatemplate.model.repository;

import ar.com.itec1misiones.javatemplate.model.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
