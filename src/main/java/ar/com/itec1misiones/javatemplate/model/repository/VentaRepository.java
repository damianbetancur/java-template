package ar.com.itec1misiones.javatemplate.model.repository;

import ar.com.itec1misiones.javatemplate.model.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
