package com.atividade.model;

public class Combustivel {
    private double precoGasolina;
    private double precoEtanol;
    private double resultado;

    public Combustivel(double precoGasolina, double precoEtanol, double resultado) {
        this.precoGasolina = precoGasolina;
        this.precoEtanol = precoEtanol;
        this.resultado = resultado;
    }

    public double getPrecoGasolina() {
        return this.precoGasolina;
    }

    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public double getPrecoEtanol() {
        return this.precoEtanol;
    }

    public void setPrecoEtanol(double precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double compararCombustivel(){
        return resultado = (precoGasolina * 70) / 100;
    }

    public String etanolCompensa(){
        if(this.precoEtanol <= this.resultado){
            return "CUMPENSA";
        } else {
            return "NUM CUMPENSA";
        }
    }
}
