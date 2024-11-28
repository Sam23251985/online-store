package com.garcia.service_inventarios.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name= "productos")
public class Producto {

    @Id
    @Column(name = "id_productos", nullable = false, unique = true)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name="precio", nullable = false)
    private BigDecimal precio;
    @Column(name = "stock")
    private Integer stock;
}
