package com.garcia.service_pedidos.model.dto;

import com.garcia.service_pedidos.model.entity.ProductoPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private LocalDateTime fecha;
    private Cliente cliente;
    private List<ProductoPedido> productosPedido;
    private BigDecimal total;
}
