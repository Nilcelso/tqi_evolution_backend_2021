package com.tqi.analisecredito.api.controller;

import com.tqi.analisecredito.api.exception.RegraDeNegocioException;
import com.tqi.analisecredito.api.model.EmprestimoExpandResponse;
import com.tqi.analisecredito.api.model.EmprestimoRequest;
import com.tqi.analisecredito.api.model.EmprestimoResponse;
import com.tqi.analisecredito.domain.usecase.EmprestimoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/emprestimos")
public class SolicitacaoEmprestimoController {

    @Autowired
    private EmprestimoUseCase emprestimoUseCase;

    @PostMapping
    public ResponseEntity<EmprestimoResponse> cadastrar(@RequestBody EmprestimoRequest request) throws RegraDeNegocioException {

        final var response = emprestimoUseCase.salvar(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/cliente_id={cliente_id}")
    public ResponseEntity<List<EmprestimoResponse>> listarPorCliente(@PathVariable("cliente_id") final Long idCliente){

        var listaEmprestimos = emprestimoUseCase.buscarEmprestimosPorCliente(idCliente);

        return ResponseEntity.ok(listaEmprestimos);
    }

    @GetMapping("/{id}/expand")
    public ResponseEntity<EmprestimoExpandResponse> listarPorClienteExpand(@PathVariable("id") final Long idEmprestimo){

        return ResponseEntity.ok(emprestimoUseCase.buscarEmprestimosExpandPorCliente(idEmprestimo));
    }
}
