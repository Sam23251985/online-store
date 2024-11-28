package com.garcia.service_pedidos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name= "pedidos")
public class Pedido {

    @Id
    @Column(name = "id_pedidos", nullable = false, unique = true)
    private Long id;
    @Column(name="fecha", nullable = false)
    private LocalDateTime fecha;
    @Column(name="id_cliente", nullable=false)
    private Long cliente;
    @Column(name="total", nullable = false)
    private BigDecimal total;
}
