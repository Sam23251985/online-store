package com.garcia.service_inventarios.service;

import com.garcia.service_inventarios.mapper.ProductoMapper;
import com.garcia.service_inventarios.model.dto.ProductoResponseDTO;
import com.garcia.service_inventarios.model.entity.Producto;
import com.garcia.service_inventarios.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    @Transactional
    public List<ProductoResponseDTO> devolverProductos(){
        List<Producto> productos = productoRepository.listarProductos();
        return productoMapper.convertToListDTO(productos);
    }
}
