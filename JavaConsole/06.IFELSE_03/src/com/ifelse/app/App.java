package com.ifelse.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);

        String nome;
        double nota;

        System.out.println("Insira o nome: ");
        nome = leia.nextLine();

        System.out.println("Insire a nota: ");
        nota = leia.nextDouble();

        if (nota >= 7) {
            System.out.println("O aluno " + nome + " está aprovado!");
        }else if(nota >= 5){
            System.out.println("O aluno " + nome + " está de recuperação!");
        } else{
            System.out.println("O aluno " + nome + " está reprovado!");
        }

        leia.close();
    }
}