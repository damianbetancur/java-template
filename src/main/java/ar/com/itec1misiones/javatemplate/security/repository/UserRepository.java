package ar.com.itec1misiones.javatemplate.security.repository;

import ar.com.itec1misiones.javatemplate.security.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
}
