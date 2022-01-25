package com.tqi.analisecredito.api.mapper;

import com.tqi.analisecredito.api.model.response.EmprestimoExpandResponse;
import com.tqi.analisecredito.api.model.request.EmprestimoRequest;
import com.tqi.analisecredito.api.model.response.EmprestimoResponse;
import com.tqi.analisecredito.domain.model.Emprestimo;
import org.mapstruct.Mapper;

@Mapper
public interface EmprestimoMapper {
    Emprestimo toEntity(EmprestimoRequest request);

    default EmprestimoResponse toResponse(Emprestimo entity) {
        return EmprestimoResponse.builder()
                .id(entity.getId())
                .qtdParcelas(entity.getQtdParcelas())
                .valor(entity.getValor())
                .clienteId(entity.getCliente().getId())
                .build();
    }

    default EmprestimoExpandResponse toResponseExpand(Emprestimo entity) {
        return EmprestimoExpandResponse.builder()
                .id(entity.getId())
                .qtdParcelas(entity.getQtdParcelas())
                .valor(entity.getValor())
                .clienteId(entity.getCliente().getId())
                .emailCliente(entity.getCliente().getEmail())
                .rendaCliente(entity.getCliente().getRenda())
                .dataPrimeiraParcela(entity.getDataPrimeiraParcela())
                .build();
    }
}
