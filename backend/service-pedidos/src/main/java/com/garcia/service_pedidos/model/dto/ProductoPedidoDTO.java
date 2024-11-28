package com.garcia.service_pedidos.model.dto;

import com.garcia.service_pedidos.model.entity.Pedido;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPedidoDTO {

    @NotNull(message = "El id del producto no puede estar vacio")
    private Long id;
    @NotBlank(message = "El nombre del producto no puede estar vacio")
    private String nombre;
    @NotBlank(message = "La descripcion del producto no puede estar vacio")
    private String descripcion;
    @NotNull(message = "El precio no puede ser vacio")
    @DecimalMin(value = "0.01", message = "La cantidad debe ser mayor que cero")
    private BigDecimal precio;
    @NotNull(message = "El stock no puede ser vacio")
    @Min(value = 1, message = "la cantidad debe ser mayor que uno")
    private Integer stock;
    @Nullable
    private Pedido pedido;
}
