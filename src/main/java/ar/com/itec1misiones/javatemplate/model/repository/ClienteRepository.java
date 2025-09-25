package ar.com.itec1misiones.javatemplate.model.repository;
import ar.com.itec1misiones.javatemplate.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
