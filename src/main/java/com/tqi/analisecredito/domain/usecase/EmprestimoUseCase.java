package com.tqi.analisecredito.domain.usecase;

import com.tqi.analisecredito.api.exception.RecursoNaoEncontradoException;
import com.tqi.analisecredito.api.exception.RegraDeNegocioException;
import com.tqi.analisecredito.api.mapper.EmprestimoMapper;
import com.tqi.analisecredito.api.model.EmprestimoExpandResponse;
import com.tqi.analisecredito.api.model.EmprestimoRequest;
import com.tqi.analisecredito.api.model.EmprestimoResponse;
import com.tqi.analisecredito.domain.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoUseCase {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private ClienteUseCase clienteUseCase;

    @Autowired
    private EmprestimoMapper mapper;

    public EmprestimoResponse salvar(EmprestimoRequest request) throws RegraDeNegocioException {
        validaEmprestimo(request);

        if(clienteUseCase.buscar().stream().filter(response -> request.getCliente().getId() == response.getId()).findFirst().isEmpty())
            throw new RecursoNaoEncontradoException("Cliente inexistente");

        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<EmprestimoResponse> buscarEmprestimosPorCliente(Long idCliente) {

        var listaEmprestimos = repository.findAllByClienteId(idCliente);

        return listaEmprestimos.stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public EmprestimoExpandResponse buscarEmprestimosExpandPorCliente(Long idEmprestimo) {

        return mapper.toResponseExpand(repository.findById(idEmprestimo).orElseThrow(
                () -> new RecursoNaoEncontradoException("Emprestimo com id", idEmprestimo.toString())));
    }

    private void validaEmprestimo(EmprestimoRequest request) throws RegraDeNegocioException{
        if(request.getDataPrimeiraParcela().isAfter(LocalDate.now().plusDays(90))){
            throw new RegraDeNegocioException("Data da primeira parcela não pode ser maior que 90 dias a partir da data atual.");
        }

        if(request.getQtdParcelas() > 60){
            throw new RegraDeNegocioException("Quantidade de parcelas não pode ser maior que 60.");
        }
    }

}
