package ar.com.itec1misiones.javatemplate.repository;
import ar.com.itec1misiones.javatemplate.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    Cliente findByDni(String dni);
    List<Cliente> findByDniStartingWith(String dni);
}
