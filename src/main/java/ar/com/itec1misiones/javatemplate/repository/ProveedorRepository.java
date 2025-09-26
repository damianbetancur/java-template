package ar.com.itec1misiones.javatemplate.repository;

import ar.com.itec1misiones.javatemplate.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
