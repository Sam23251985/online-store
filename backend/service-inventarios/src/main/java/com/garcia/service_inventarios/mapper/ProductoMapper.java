package com.garcia.service_inventarios.mapper;

import com.garcia.service_inventarios.model.dto.ProductoResponseDTO;
import com.garcia.service_inventarios.model.entity.Producto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductoMapper {

    private final ModelMapper modelMapper;

    public List<ProductoResponseDTO> convertToListDTO(List<Producto> productos){
        return productos.stream().map(this::convertToDTO).toList();
    }

    public ProductoResponseDTO convertToDTO(Producto producto){
        return modelMapper.map(producto, ProductoResponseDTO.class);
    }
}


