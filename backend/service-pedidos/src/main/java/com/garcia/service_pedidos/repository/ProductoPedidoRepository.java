package com.garcia.service_pedidos.repository;

import com.garcia.service_pedidos.model.entity.ProductoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Long> {
}
