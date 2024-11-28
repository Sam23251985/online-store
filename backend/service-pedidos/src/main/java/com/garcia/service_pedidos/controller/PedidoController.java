package com.garcia.service_pedidos.controller;

import com.garcia.service_pedidos.model.dto.PedidoRequestDTO;
import com.garcia.service_pedidos.model.dto.PedidoResponseDTO;
import com.garcia.service_pedidos.service.PedidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
@RefreshScope
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity<PedidoResponseDTO> registrarPedido(@Valid @RequestBody PedidoRequestDTO pedidoRequestDTO){
        PedidoResponseDTO pedidoResponseDTO = pedidoService.registrarPedido(pedidoRequestDTO);
        return new ResponseEntity<>(pedidoResponseDTO, HttpStatus.CREATED);
    }
}
