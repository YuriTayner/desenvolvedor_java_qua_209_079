package com.ifelse.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);

        String nome;
        int idade;

        System.out.println("Insira a nome: ");
        nome = leia.nextLine();

        System.out.println("Insira a idade: ");
        idade = leia.nextInt();

        if (idade >= 18) {
            System.out.println(nome + " tem " + idade + " anos, logo é maior de idade!");
        } else{
            System.out.println(nome + " tem " + idade + " anos, logo é menor de idade");
        }

        leia.close();
    }
}
