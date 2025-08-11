package com.objeto.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //TODO

        Scanner leia = new Scanner(System.in);
        Pessoa usuario = new Pessoa("", 0, 0.0);

        System.out.println("Informe o nome: ");
        usuario.nome = leia.nextLine();

        System.out.println("Informe a idade: ");
        usuario.idade = leia.nextInt();

        System.out.println("Informe a altura");
        usuario.altura = leia.nextDouble();

        System.out.println(usuario.cumprimentar());
        usuario.exibirDados();

        leia.close();
    }
}
