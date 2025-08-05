package com.ifelse.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        String nome;
        int idade;
        double altura;

        System.out.println("Insira o nome: ");
        nome = leia.nextLine();

        System.out.println("Insira a Idade");
        idade = leia.nextInt();

        System.out.println("Insira a altura");
        altura = leia.nextDouble();

        if (idade >= 12 && altura >= 1.15) {
            System.out.println("Entrada Aprovada" + nome);
        } else {
            System.out.println("Entrada Negada " + nome);
            if (idade < 12) {
                System.out.print("Idade inválida ");
            }
            if(altura < 1.15){
                System.out.println("Altura inválida");
            }
        }

        leia.close();
    }
}
