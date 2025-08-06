package com.atividade02.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        String nome;
        int idade, escolha, n;
        n = 0;

        System.out.println("---CINEMARK---");
        while (n == 0) {
            System.out.println("Filme em cartaz:");
            System.out.println("1 - Pecadores, 2025, 16 anos");
            System.out.println("2 - Lilo & Stitch, 2025, indicação livre");
            System.out.println("3 - Superman, 2025, 14 anos");
            System.out.println("4 - Quarteto fantástico, 2025, 12 anos");
            System.out.println("5 - A hora do mal, 2025, 18 anos");
            System.out.println("Insira o filme que quer assistir(1, 2, etc):");
        }

        leia.close();
    }
}
