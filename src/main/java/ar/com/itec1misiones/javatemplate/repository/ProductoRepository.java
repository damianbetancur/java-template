package ar.com.itec1misiones.javatemplate.repository;

import ar.com.itec1misiones.javatemplate.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
