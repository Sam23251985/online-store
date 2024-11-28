package com.garcia.service_inventarios.repository;

import com.garcia.service_inventarios.model.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p")
    List<Producto> listarProductos();
}
