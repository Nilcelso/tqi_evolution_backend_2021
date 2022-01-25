package com.tqi.analisecredito.common.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }

    public RecursoNaoEncontradoException(String nomeRecurso, String idRecurso) {
        this(String.format("Recurso não encontrado para %s {%s}", nomeRecurso, idRecurso));
    }
}
