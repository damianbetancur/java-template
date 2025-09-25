package ar.com.itec1misiones.javatemplate.model.repository;

import ar.com.itec1misiones.javatemplate.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
