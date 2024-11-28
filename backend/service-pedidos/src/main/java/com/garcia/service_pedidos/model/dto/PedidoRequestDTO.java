package com.garcia.service_pedidos.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {

    @NotNull(message = "El cliente no puede ser vacio")
    private Long cliente;
    @NotNull(message = "La lista de preductos no puede estar vacia")
    private List<ProductoPedidoDTO> productos;
}


