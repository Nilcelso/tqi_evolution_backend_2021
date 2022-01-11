package com.tqi.analisecredito.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "endereco", length = 2000, nullable = false)
    private String endereco;

    @Column(name = "cpf", nullable = false)
    private Long cpf;

    @Column(name = "rg", length = 2000, nullable = false)
    private String rg;

    @Column(name = "renda", nullable = false)
    private BigDecimal renda;

    @Column(name = "senha", length = 2000, nullable = false)
    private String senha;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;
}