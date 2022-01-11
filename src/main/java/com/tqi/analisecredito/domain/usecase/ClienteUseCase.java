package com.tqi.analisecredito.domain.usecase;

import com.tqi.analisecredito.api.mapper.ClienteMapper;
import com.tqi.analisecredito.api.model.ClienteRequest;
import com.tqi.analisecredito.api.model.ClienteResponse;
import com.tqi.analisecredito.domain.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper mapper;

    public List<ClienteResponse> buscar() {
        return clienteRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public ClienteResponse salvar(ClienteRequest clienteRequest) {
        log.info("Inserindo cliente na base: {}", clienteRequest);
        return mapper.toResponse(clienteRepository.save(mapper.toEntity(clienteRequest)));
    }
}
