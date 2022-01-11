package com.tqi.analisecredito.api.controller;

import com.tqi.analisecredito.api.model.ClienteRequest;
import com.tqi.analisecredito.api.model.ClienteResponse;
import com.tqi.analisecredito.domain.usecase.ClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteUseCase clienteUseCase;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscar(){
        return ResponseEntity.ok(clienteUseCase.buscar());
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastro(@RequestBody final ClienteRequest request){
        var clienteResponse = clienteUseCase.salvar(request);

        return ResponseEntity.ok(clienteResponse);
    }
}
