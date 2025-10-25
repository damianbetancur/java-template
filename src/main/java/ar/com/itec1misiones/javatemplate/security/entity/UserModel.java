package ar.com.itec1misiones.javatemplate.security.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String user;
    private String password;
}
