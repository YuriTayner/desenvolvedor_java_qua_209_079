package com.regras.app;

import java.util.Scanner;
import com.regras.model.Conta;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Conta cc = new Conta(null, null, "Nubank", "0101-0", 0.0);

        int esc;
        esc = 1;
        double valor;

        System.out.println("Insira o nome do titular: ");
        cc.setTitular(scan.nextLine());

        System.out.println("Insira o CPF do titular: ");
        cc.setCpf(scan.nextLine());

        while (esc != 4) {
            System.out.println("---BANCO---");
            System.out.println("1 - Exibir dados da conta");
            System.out.println("2 - Fazer saque");
            System.out.println("3 - Fazer depósito");
            System.out.println("4 - SAIR DO PROGRAMA");
            System.out.println("Entrada: ");
            esc = scan.nextInt();

           switch (esc) {
            case 1:
                cc.exibirDados();
                break;
            case 2:
                System.out.println("informe o valor do saque: R$");
                valor = scan.nextDouble();
                System.out.println((valor > 0 && valor <= cc.getSaldo()) ? "Saque efetuado com sucesso. Saldo: R$ " + cc.fazerSaque(valor): "Valor do depósito inválido.");
                break;

            case 3:
                System.out.println("informe o valor do depósito: R$");
                valor = scan.nextDouble();
                System.out.println((valor > 0) ? "Depósito efetuado com sucesso. Saldo: R$ " + cc.fazerDeposito(valor) : "Valor do depósito inválido.");
                break;

            case 4:
                System.out.println("PROGRAMA ENCERRADO!");
                break;
            default:
                System.out.println("Opção inválida!");
           }

        }
        //TODO: comlete o codigo-fonte
        scan.close();
    }
}
