package com.proyecto.tienda.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de la tabla clientes
 */
@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telephone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "active")
    private int active;

    @Column(name="role")
    private String role;

    @OneToMany(mappedBy = "clienteEntity", cascade = {CascadeType.ALL})
    private List<CompraEntity> compras;

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }
}
