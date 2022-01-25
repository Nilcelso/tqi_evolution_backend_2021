package com.tqi.analisecredito.api.controller;

import com.tqi.analisecredito.api.model.request.ClienteRequest;
import com.tqi.analisecredito.api.model.response.ClienteResponse;
import com.tqi.analisecredito.domain.usecase.ClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteUseCase clienteUseCase;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscar() {
        return ResponseEntity.ok(clienteUseCase.buscar());
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastro(@RequestBody final ClienteRequest request) {
        var clienteResponse = clienteUseCase.salvar(request);

        return ResponseEntity.ok(clienteResponse);
    }
}
