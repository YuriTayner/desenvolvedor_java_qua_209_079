package com.atividade.model;

public interface IPessoa {
    public double calcularImc(double peso, double altura, double imc);

    public String indicarImc(String nome, double imc);
}
