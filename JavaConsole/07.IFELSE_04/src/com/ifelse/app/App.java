package com.ifelse.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        String nome;
        int idade;

        System.out.println("Insira seu nome: ");
        nome = leia.nextLine();

        System.out.println("Insira sua idade: ");
        idade = leia.nextInt();

        System.out.println(nome + ((idade >=  18) ? " é maior de idade" : " é menor de idade"));

        leia.close();
    }
}
