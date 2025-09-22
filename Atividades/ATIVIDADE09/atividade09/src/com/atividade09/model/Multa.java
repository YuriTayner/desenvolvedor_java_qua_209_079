package com.atividade09.model;

public class Multa implements IMulta{
    private String fabricante;
    private String modelo;
    private String placa;
    private String proprietario;
    private double tempo;
    private double dist;
    private double multa;

    public Multa() {
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getTempo() {
        return this.tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getDist() {
        return this.dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public double getMulta() {
        return this.multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String exibirDadosCarro() {
        return "AAAAAAAA";
    }


    @Override
    public double calcularMulta() {
        return multa = dist / (tempo / 60);
    }


    @Override
    public String resultadoMulta() {
        if(this.multa > 80){
            return "Multa emitida";
        } else{
            return  "Multa não emitida";
        }
    }

}
