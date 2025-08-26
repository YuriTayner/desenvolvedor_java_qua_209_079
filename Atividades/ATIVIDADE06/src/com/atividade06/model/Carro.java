package com.atividade06.model;

import com.atividade06.interfaces.ICarro;

public class Carro implements ICarro{
    private String fabricante;
    private String modelo;
    private String ano;
    private String cor;
    private Pessoa proprietario;


    public Carro(String fabricante, String modelo, String ano, String cor, Pessoa proprietario) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.proprietario = proprietario;
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

    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Pessoa getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }


    @Override
    public String exibirDados() {
        return "DADOS DO CARRO\n" + this.fabricante + " " + this.modelo + " " + this.ano + " " + this.cor + ". \nDADOS DO PROPRIETÁRIO\n" +
        "Nome do proprietário: " + this.proprietario.getNome() + "\nCPF do proprietário: " + this.proprietario.getCpf() + "\nData de nascimento: " + this.proprietario.getDataNascimento() +
        "\nTelefone do proprietário: " + this.proprietario.getTelefone() + "\nEmail do proprietário: " + this.proprietario.getEmail() + "\nEndereço do proprietário: " + 
        this.proprietario.getEndereco();
    }
}
