package com.tqi.analisecredito.api.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    private String endereco;
    @NotBlank
    private Long cpf;
    private String rg;
    @NotBlank
    private BigDecimal renda;
    @NotBlank
    private String senha;
}
