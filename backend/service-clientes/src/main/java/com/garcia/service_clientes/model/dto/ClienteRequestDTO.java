package com.garcia.service_clientes.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    @NotNull(message = "El numero de DNI no puede estar vacio")
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El correo no puede estar vacio")
    @Email(message = "El correo debe ser válido")
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacia")
    private String contraseña;
    @NotBlank(message = "La direccion no puede estar vacia")
    private String direccion;
}
