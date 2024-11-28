package com.garcia.service_clientes.repository;

import com.garcia.service_clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.id=:id")
    Cliente buscarPorId(@Param("id") Long id);
}
