package com.tqi.analisecredito.api.exception.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    NAO_AUTORIZADO("/nao-autorizado", "Não Autorizado"),
    HEADER_INVALIDO("/header-invalido", "Header inválido"),
    METODO_NAO_SUPORTADO("/metodo-nao-suportado", "Método não suportado");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://tqi.com" + path;
        this.title = title;
    }
}
