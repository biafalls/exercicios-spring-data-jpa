package com.desafios.exercicios_spring_data_jpa.aula1.enums;

public enum CodigoErro {
    NOT_FOUND(404, "Recurso não encontrado"),
    BAD_REQUEST(400, "Requisição inválida"),
    INTERNAL_SERVER_ERROR(500, "Erro interno do servidor");

    private final int cod;
    private final String descricao;

    CodigoErro(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

}
