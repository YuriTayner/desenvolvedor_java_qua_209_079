package com.escolha.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        int n1, n2;
        double result;
        String operacao;

        System.out.println("Insire o primeiro número: ");
        n1 = leia.nextInt();

        System.out.println("Insire o segundo número: ");
        n2 = leia.nextInt();

        leia.nextLine();

        System.out.println("Escolha a operação: ");
        System.out.println("1 - SOMAR");
        System.out.println("2 - SUBTRAIR");
        System.out.println("3 - MULTIPLICAR");
        System.out.println("4 - DIVIDIR");
        System.out.println("Escolha :");
        operacao = leia.nextLine();

        switch (operacao) {
            case "1":
                result = n1 + n2;
                System.out.println("O resultado do SOMAR é: " + result);
                break;
             case "2":
                result = n1 - n2;
                System.out.println("O resultado do SUBTRAIR é: " + result);
                break;
            case "3":
                result = n1 * n2;
                System.out.println("O resultado do MULTIPLICAR é: " + result);
                break;
            case "4":
                result = n1 / n2;
                System.out.println("O resultado do DIVIDIR é: " + result);
                break;
            default:
            System.out.println("Operador inválido");
        } 

        leia.close();
    }
}
