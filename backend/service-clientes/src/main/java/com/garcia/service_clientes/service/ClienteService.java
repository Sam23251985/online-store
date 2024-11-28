package com.garcia.service_clientes.service;

import com.garcia.service_clientes.mapper.ClienteMapper;
import com.garcia.service_clientes.model.dto.ClienteRequestDTO;
import com.garcia.service_clientes.model.dto.ClienteResponseDTO;
import com.garcia.service_clientes.model.entity.Cliente;
import com.garcia.service_clientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Transactional
    public ClienteResponseDTO registrarCliente(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteMapper.convertToEntiTy(clienteRequestDTO);
        clienteRepository.save(cliente);
        return clienteMapper.convertToDTO(cliente);
    }

    @Transactional
    public ClienteResponseDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        return clienteMapper.convertToDTO(cliente);
    }
}
