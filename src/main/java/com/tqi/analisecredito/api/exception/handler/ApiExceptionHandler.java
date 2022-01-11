package com.tqi.analisecredito.api.exception.handler;

import com.tqi.analisecredito.api.exception.RecursoNaoEncontradoException;
import com.tqi.analisecredito.api.exception.RegraDeNegocioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    protected ResponseEntity<Object> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex, WebRequest request) {

        var status = HttpStatus.NOT_FOUND;
        var problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
        var detail = ex.getMessage();
        var problem = createProblemBuilder(status, problemType, detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    protected ResponseEntity<Object> handleRegraDeNegocioException(RegraDeNegocioException ex, WebRequest request) {

        var status = HttpStatus.BAD_REQUEST;
        var problemType = ProblemType.ERRO_NEGOCIO;
        var detail = ex.getMessage();
        var problem = createProblemBuilder(status, problemType, detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status,
                                                        ProblemType problemType, String detail) {

        return Problem.builder()
                .status(status.value())
                .type(problemType.getUri())
                .detail(detail);
    }
}
