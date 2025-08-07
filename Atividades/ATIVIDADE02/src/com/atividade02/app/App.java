package com.atividade02.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        String nome;
        int idade, escolha, n;
        n = 0;

        System.out.println("---CINEMARK---");
        System.out.println("Cadastro");
        System.out.println("Insira seu nome: ");
        nome = leia.nextLine();
        System.out.println("Insira sua idade: ");
        idade = leia.nextInt();

        while (n == 0) {
            System.out.println("---Filme em cartaz---");
            System.out.println("1 - Pecadores, 2025, 16 anos");
            System.out.println("2 - Lilo & Stitch, 2025, indicação livre");
            System.out.println("3 - Superman, 2025, 14 anos");
            System.out.println("4 - Quarteto fantástico, 2025, 12 anos");
            System.out.println("5 - A hora do mal, 2025, 18 anos");
            System.out.println("Insira o filme que quer assistir(1, 2, etc): ");
            escolha =  leia.nextInt();
            switch (escolha) {
                case 1:
                    if (idade >= 16) {
                        System.out.printf("%s %d anos Filme: Pecadores%n", nome, idade);
                        n += 1;
                    } else{
                        System.out.printf("%s %d anos, idade não corresponde a idade indicada para esse filme!", nome, idade);
                        System.out.println("Selecione outro filme!");
                    }
                    break;

                case 2:
                      System.out.printf("%s %d anos Filme: Liso & Stitch%n", nome, idade);
                    n += 1;
                    break;

                case 3:
                    if (idade >= 14) {
                       System.out.printf("%s %d anos Filme: Superman%n", nome, idade);
                        n += 1;
                    } else{
                        System.out.printf("%s %d anos, idade não corresponde a idade indicada para esse filme!", nome, idade);
                        System.out.println("Selecione outro filme!");
                    }
                    break;
            
                case 4:
                    if (idade >= 12) {
                         System.out.printf("%s %d anos Filme: Quarteto fantástico%n", nome, idade);
                        n += 1;
                    } else{
                        System.out.printf("%s %d anos, idade não corresponde a idade indicada para esse filme!", nome, idade);
                        System.out.println("Selecione outro filme!");
                    }
                    break;

                case 5:
                    if (idade >= 18) {
                      System.out.printf("%s %d anos Filme: A hora do mal%n", nome, idade);
                        n += 1;
                    } else{
                        System.out.printf("%s %d anos, idade não corresponde a idade indicada para esse filme!", nome, idade);
                        System.out.println("Selecione outro filme!");
                    }
                    break;
            
                default:
                    System.out.println("Valor inválido tente novamente!");
                    break;
            }
        }
        System.out.println("Ingresso emitido com sucesso! Tenha um bom filme");

        leia.close();
    }
}
