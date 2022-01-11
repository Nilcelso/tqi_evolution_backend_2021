package com.tqi.analisecredito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "quantidade_parcelas", nullable = false)
    private Integer qtdParcelas;

    @Column(name = "data_primeira_parcela", nullable = false)
    private LocalDate dataPrimeiraParcela;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
