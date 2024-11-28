package com.garcia.service_pedidos.service;

import com.garcia.service_pedidos.mapper.ProductoPedidoMapper;
import com.garcia.service_pedidos.model.dto.Cliente;
import com.garcia.service_pedidos.model.dto.PedidoRequestDTO;
import com.garcia.service_pedidos.model.dto.PedidoResponseDTO;
import com.garcia.service_pedidos.model.dto.ProductoPedidoDTO;
import com.garcia.service_pedidos.model.entity.Pedido;
import com.garcia.service_pedidos.model.entity.ProductoPedido;
import com.garcia.service_pedidos.repository.PedidoRepository;
import com.garcia.service_pedidos.repository.ProductoPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoPedidoRepository productoPedidoRepository;
    private final ProductoPedidoMapper productoPedidoMapper;
    private final WebClient.Builder webClientBuilder;

    @Transactional
    public PedidoResponseDTO registrarPedido(PedidoRequestDTO pedidoRequestDTO) {

        Pedido pedidoPrueba;
        Pedido pedido = new Pedido();
        Long id;
        LocalDateTime fechaPedido = LocalDateTime.now();
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        Long cliente = pedidoRequestDTO.getCliente();
        BigDecimal total = BigDecimal.ZERO;

        Cliente cli = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/clientes/{id}", pedidoRequestDTO.getCliente())
                .retrieve()
                .bodyToMono(Cliente.class)
                .block();

        do{
            id = Math.round(Math.random()*1000000);
            pedidoPrueba = pedidoRepository.buscarPorId(id);
        }while(pedidoPrueba != null);

        List<ProductoPedidoDTO> productosDTO = pedidoRequestDTO.getProductos();
        List<ProductoPedido> productos = new ArrayList<>();

        for(ProductoPedidoDTO productoPedidoDTO : productosDTO){
            total = total.add(BigDecimal.valueOf(productoPedidoDTO.getStock())
                    .multiply(productoPedidoDTO.getPrecio()));
            ProductoPedido productoPedido = productoPedidoMapper.convertToEntity(productoPedidoDTO);
            productoPedido.setPedido(pedido);
            productos.add(productoPedido);
        }

        pedido.setId(id);
        pedido.setFecha(fechaPedido);
        pedido.setCliente(cliente);
        pedido.setTotal(total);
        pedidoRepository.save(pedido);

        for(ProductoPedido productoPedido : productos){
            productoPedidoRepository.save(productoPedido);
        }

        pedidoResponseDTO.setId(id);
        pedidoResponseDTO.setFecha(fechaPedido);
        pedidoResponseDTO.setCliente(cli);
        pedidoResponseDTO.setProductosPedido(productos);
        pedidoResponseDTO.setTotal(total);

        return pedidoResponseDTO;
    }
}
