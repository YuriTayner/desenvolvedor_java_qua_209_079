package com.atividade.app;

public class Conta {
    String titular;
    String cpf;
    String agencia;
    int numeroConta;
    double saldo;


    public Conta(String titular, String cpf, String agencia, int numeroConta, double saldo) {
        this.titular = titular;
        this.cpf = cpf;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }



    public void exibirDados(){
        System.out.println("Nome do titular " + this.titular);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número da conta: " + this.numeroConta);
        System.out.println("Saldo: R$" + String.format("%.2f", this.saldo));
    }


    public double sacar(double valor){
        this.saldo -= valor;
        return this.saldo;
    }

    public double depositar(double valor){
        this.saldo += valor;
        return this.saldo;
    }
    
    
}
