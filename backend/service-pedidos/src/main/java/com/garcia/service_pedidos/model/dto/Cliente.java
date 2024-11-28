package com.garcia.service_pedidos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    private String direccion;
}
