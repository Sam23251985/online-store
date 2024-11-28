package com.garcia.service_clientes.controller;

import com.garcia.service_clientes.model.dto.ClienteRequestDTO;
import com.garcia.service_clientes.model.dto.ClienteResponseDTO;
import com.garcia.service_clientes.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@RefreshScope
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/registro")
    public ResponseEntity<ClienteResponseDTO> registrarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
        ClienteResponseDTO clienteResponseDTO = clienteService.registrarCliente(clienteRequestDTO);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorId(@PathVariable Long id){
        ClienteResponseDTO clienteResponseDTO = clienteService.buscarClientePorId(id);
        return new ResponseEntity<>(clienteResponseDTO, HttpStatus.OK);
    }
}
