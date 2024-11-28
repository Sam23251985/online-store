package com.garcia.service_inventarios.controller;

import com.garcia.service_inventarios.model.dto.ProductoResponseDTO;
import com.garcia.service_inventarios.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
@RefreshScope
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<ProductoResponseDTO>> listarProductos() {
        List<ProductoResponseDTO> productos = productoService.devolverProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
