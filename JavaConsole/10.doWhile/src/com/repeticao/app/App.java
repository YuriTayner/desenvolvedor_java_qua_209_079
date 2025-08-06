package com.repeticao.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        String nome;
        int idade, opcao;
        double altura;

        do{
            System.out.println("1 - Registrar nova entrada.");
            System.out.println("2 - Sair do programa.");
            System.out.println("Informe a opção desejada: ");
            opcao = leia.nextInt();
            
            if (opcao == 1) {
                leia.nextLine();

                System.out.println("Qual o seu nome? ");
                nome = leia.nextLine();

                System.out.println("Qual a sua idade? ");
                idade = leia.nextInt();

                System.out.println("Qual a sua altura? ");
                altura = leia.nextDouble();

                if (idade >= 12 && altura >= 1.15) {
                    System.out.println(nome + " está autorizado!");
                } else{
                    System.out.println(nome + " não está autorizado!");
                }

            } else if(opcao != 2){
                System.out.println("Opção inválida.");
            }
        } while(opcao != 2);

        System.out.println("PROGRAMA ENCERRADO.");

        leia.close();
    }
}
