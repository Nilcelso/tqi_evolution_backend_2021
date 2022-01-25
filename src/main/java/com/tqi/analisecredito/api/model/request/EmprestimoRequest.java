package com.tqi.analisecredito.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tqi.analisecredito.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmprestimoRequest {

    private BigDecimal valor;

    @JsonProperty(value = "data_primeira_parcela")
    private LocalDate dataPrimeiraParcela;

    @JsonProperty(value = "quantidade_parcelas")
    private Integer qtdParcelas;

    private Cliente cliente;
}
