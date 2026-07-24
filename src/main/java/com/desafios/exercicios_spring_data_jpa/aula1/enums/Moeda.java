package com.desafios.exercicios_spring_data_jpa.aula1.enums;

public enum Moeda {
    //ex7
    DOLAR(5.1), EURO(5.8), REAL(1.0);

    private final double taxa;
    Moeda(double taxa) {
        this.taxa = taxa;
    }

    public double converterPara(double valorEmReais) {
        return valorEmReais / taxa;
    }
}
