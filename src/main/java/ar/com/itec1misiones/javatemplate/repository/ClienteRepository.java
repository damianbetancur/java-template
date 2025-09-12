package ar.com.itec1misiones.javatemplate.repository;
import ar.com.itec1misiones.javatemplate.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
