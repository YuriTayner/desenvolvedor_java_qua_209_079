package com.atividade.model;

public class Pessoa implements IPessoa{
    private String nome;
    private double peso;
    private double altura;
    private double imc;


    public Pessoa(String nome, double peso, double altura, double imc) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return this.imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }


    @Override
    public double calcularImc(double peso, double altura, double imc) {
        return imc = peso / (altura * altura);
    }


    @Override
    public String indicarImc(String nome, double imc) {
        if (imc < 18.5) {
                return nome + ": Magreza";
            } else if (imc >= 18.5 && imc <= 24.9) {
                return nome + ": Normal";
            } else if (imc >= 25 && imc <= 29.9) {
                return nome + ": Sobrepeso";
            } else if (imc >= 30 && imc <= 39.9){
                return nome + ": Obesidade";
            } else if (imc >= 40) {
                return nome + ": Obesidade grave";
            }
        return nome;
    }
}
