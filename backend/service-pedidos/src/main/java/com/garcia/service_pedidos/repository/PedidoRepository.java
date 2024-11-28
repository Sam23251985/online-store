package com.garcia.service_pedidos.repository;

import com.garcia.service_pedidos.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.id=:id")
    Pedido buscarPorId(@Param("id") long id);
}
