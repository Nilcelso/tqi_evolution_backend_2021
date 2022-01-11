package com.tqi.analisecredito.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoExpandResponse {

    private Long id;
    private BigDecimal valor;

    @JsonProperty(value = "quantidade_parcelas")
    private Integer qtdParcelas;

    @JsonProperty(value = "data_primeira_parcela")
    private LocalDate dataPrimeiraParcela;

    @JsonProperty(value = "email_cliente")
    private String emailCliente;

    @JsonProperty(value = "renda_cliente")
    private BigDecimal rendaCliente;

    @JsonProperty(value = "cliente_id")
    private Long clienteId;
}
