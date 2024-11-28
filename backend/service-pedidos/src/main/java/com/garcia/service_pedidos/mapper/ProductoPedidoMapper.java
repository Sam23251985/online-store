package com.garcia.service_pedidos.mapper;

import com.garcia.service_pedidos.model.dto.ProductoPedidoDTO;
import com.garcia.service_pedidos.model.entity.ProductoPedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductoPedidoMapper {

    private final ModelMapper modelMapper;

    public ProductoPedidoDTO convertToDTO(ProductoPedido productoPedido){
        return modelMapper.map(productoPedido, ProductoPedidoDTO.class);
    }

    public List<ProductoPedidoDTO> convertToListDTO(List<ProductoPedido> productoPedidos){
        return productoPedidos.stream().map(this::convertToDTO).toList();
    }

    public ProductoPedido convertToEntity(ProductoPedidoDTO productoPedidoDTO){
        return modelMapper.map(productoPedidoDTO, ProductoPedido.class);
    }
}
