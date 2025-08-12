package com.heranca.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        PessoaFisica usuario = new PessoaFisica();
        PessoaJuridica empresa = new PessoaJuridica();

        System.out.println("Informe o nome do usuario: ");
        usuario.nome = leia.nextLine();
         
        System.out.println("Informe o cpf do usuario: ");
        usuario.cpf = leia.nextLine();

        System.out.println("Informe o e-mail do usuario: ");
        usuario.email = leia.nextLine();

        System.out.println("Informe o telefone do usuario: ");
        usuario.telefone = leia.nextLine();

        System.out.println("Informe o endereço do usuario: ");
        usuario.nome = leia.nextLine();

        usuario.cumprimentar();
        System.out.println("nome: " + usuario.nome);
        System.out.println("cpf: " + usuario.cpf);
        System.out.println("E-mail: " + usuario.email);
        System.out.println("Telefone: " + usuario.telefone);
        System.out.println("Endereço: " + usuario.endereco);

        System.out.println("Razão social da empresa" + empresa.razaoSocial);
        System.out.println("Nome fantaria da empresa" + empresa.nomeFantasia);
        System.out.println("Cnpj da empresa" + empresa.cnpj);
        System.out.println("Email da empresa" + empresa.email);
        System.out.println("Telefone da empresa" + empresa.telefone);
        System.out.println("Endereço da empresa" + empresa.endereco);
    }
}
