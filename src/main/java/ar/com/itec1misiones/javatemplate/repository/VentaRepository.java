package ar.com.itec1misiones.javatemplate.repository;

import ar.com.itec1misiones.javatemplate.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
