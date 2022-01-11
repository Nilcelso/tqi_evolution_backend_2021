package com.tqi.analisecredito.api.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    private String nome;
    private String email;
    private String endereco;
    private Long cpf;
    private String rg;
    private BigDecimal renda;
    private String senha;
}
