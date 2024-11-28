package com.garcia.service_clientes.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name= "clientes")
public class Cliente {

    @Id
    @Column(name = "id_clientes", nullable = false, unique = true)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name="contraseña", nullable = false)
    private String contraseña;
    @Column(name = "direccion")
    private String direccion;

}
