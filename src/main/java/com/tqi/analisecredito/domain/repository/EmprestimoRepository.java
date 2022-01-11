package com.tqi.analisecredito.domain.repository;

import com.tqi.analisecredito.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findAllByClienteId(Long clienteId);
}
