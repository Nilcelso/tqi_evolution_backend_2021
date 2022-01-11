package com.tqi.analisecredito.api.mapper;

import com.tqi.analisecredito.api.model.ClienteRequest;
import com.tqi.analisecredito.api.model.ClienteResponse;
import com.tqi.analisecredito.domain.model.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {
    Cliente toEntity(ClienteRequest clienteRequest);
    ClienteResponse toResponse(Cliente cliente);
}