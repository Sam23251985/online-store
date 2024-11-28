package com.garcia.service_clientes.mapper;

import com.garcia.service_clientes.model.dto.ClienteRequestDTO;
import com.garcia.service_clientes.model.dto.ClienteResponseDTO;
import com.garcia.service_clientes.model.entity.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteMapper {

    private final ModelMapper modelMapper;

    public Cliente convertToEntiTy(ClienteRequestDTO clienteRequestDTO){
        return modelMapper.map(clienteRequestDTO, Cliente.class);
    }

    public ClienteResponseDTO convertToDTO(Cliente cliente){
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }
}

