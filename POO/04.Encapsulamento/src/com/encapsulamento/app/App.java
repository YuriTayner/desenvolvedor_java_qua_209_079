package com.encapsulamento.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        Pessoa usuario = new Pessoa();

        System.out.println("Nome: ");
        usuario.setNome(leia.nextLine());
        System.out.println("Idade: ");
        usuario.setIdade(leia.nextInt());

        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Idade: " + usuario.getIdade());
    }
}
