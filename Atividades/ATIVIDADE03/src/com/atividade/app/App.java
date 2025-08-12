package com.atividade.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Crie um programa com uma classe chamada Conta, com os seguintes atributos:
         * - Titular da conta
         * - CPF do titular
         * - Agência 
         * - Número da conta
         * - Saldo
         * O usuário deverá informar o nome do titular e o CPF, 
         * e o programa exibe um menu com as seguintes operações:
         * - Exibir dados da conta
         * - Fazer saque
         * - Fazer deposíto
         * - Sair do programa
         */
        Scanner leia = new Scanner(System.in);
        Conta usuario = new Conta("", "", "Banco do brasil", 01, 100.0);
        int n;
        int esc;

        esc = 1;
        n = 1;

        double valor;

        System.out.println("Insira o nome do titular: ");
        usuario.titular = leia.nextLine();

        System.out.println("Insira o CPF do titular: ");
        usuario.cpf = leia.nextLine();

        while (esc != 4) {
            System.out.println("---BANCO---");
            System.out.println("1 - Exibir dados da conta");
            System.out.println("2 - Fazer saque");
            System.out.println("3 - Fazer depósito");
            System.out.println("4 - SAIR DO PROGRAMA");
            System.out.println("Entrada: ");
            esc = leia.nextInt();

           switch (esc) {
            case 1:
                usuario.exibirDados();
                break;
            case 2:
                System.out.println("informe o valor do saque: R$");
                valor = leia.nextDouble();
                System.out.println((valor > 0 && valor <= usuario.saldo) ? "Saque efetuado com sucesso. Saldo: R$ " + usuario.sacar(valor) : "Valor do depósito inválido.");
                break;

            case 3:
                System.out.println("informe o valor do depósito: R$");
                valor = leia.nextDouble();
                System.out.println((valor > 0) ? "Depósito efetuado com sucesso. Saldo: R$ " + usuario.depositar(valor) : "Valor do depósito inválido.");
                break;

            case 4:
                System.out.println("PROGRAMA ENCERRADO!");
                break;
            default:
                System.out.println("Opção inválida!");
           }

        }

 
        leia.close();
    }
}
