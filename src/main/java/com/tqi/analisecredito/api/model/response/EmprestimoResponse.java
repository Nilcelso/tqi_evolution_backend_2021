package com.tqi.analisecredito.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tqi.analisecredito.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoResponse {

    private Long id;
    private BigDecimal valor;

    @JsonProperty(value = "quantidade_parcelas")
    private Integer qtdParcelas;

    @JsonProperty(value = "cliente_id")
    private Long clienteId;
}
