package com.garcia.service_pedidos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name= "productosPedidos")
public class ProductoPedido {

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
    @ManyToOne
    @JoinColumn(name="id_pedido", nullable=false)
    private Pedido pedido;
}
