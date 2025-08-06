package com.atividade01.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Crie um programa que receba o nome, peso e altura do usuário, e calcule o calor do seu IMC cuja fórmula é peso/altura*altura
        //E deverá ter a opção de sair do programa
        Scanner leia = new Scanner(System.in);
        String nome;
        double peso;
        double altura;
        int n;
        double imc;

        n = 0;
        while (n == 0) {
            System.out.println("Insira seu nome: ");
            nome = leia.nextLine();

            System.out.println("Insira o peso: ");
            peso = leia.nextDouble();

              System.out.println("Insira o altura: ");
            altura = leia.nextDouble();

            imc = peso / (altura * altura);

            System.out.println("Seu IMC é de: " + imc);

            if (imc < 18.5) {
                System.out.println(nome + ": Magreza");
            } else if (imc >= 18.5 && imc <= 24.9) {
                System.out.println(nome + ": Normal");
            } else if (imc >= 25 && imc <= 29.9) {
                System.out.println(nome + ": Sobrepeso");
            } else if (imc >= 30 && imc <= 39.9){
                System.out.println(nome + ": Obesidade");
            } else if (imc >= 40) {
                System.out.println(nome + ": Obesidade grave");
            }

            System.out.println("Deseja repetir? (0 - Sim)");
            n = leia.nextInt();
            imc = 0;
            leia.nextLine();
        } 
        System.out.println("Sistema encerrado!");
        leia.close();
    }
}
