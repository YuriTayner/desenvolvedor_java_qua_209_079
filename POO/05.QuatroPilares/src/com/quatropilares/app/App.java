package com.quatropilares.app;

import java.util.Scanner;

import com.quatropilares.model.PessoaFisica;
import com.quatropilares.model.PessoaJuridica;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
            PessoaFisica usuario = new PessoaFisica(null, null, null, null, null, null);
            PessoaJuridica empresa = new PessoaJuridica(null, null, null, null, null, null);
            
            //Usuario
             System.out.println("Informe os dados do usuario!");
             System.out.println("Nome: ");
             usuario.setNome(scan.nextLine());
             System.out.println("dataNascimento ");
             usuario.setDataNascimento(scan.nextLine());
             System.out.println("CPF: ");
             usuario.setCpf(scan.nextLine());
             System.out.println("Email: ");
             usuario.setEmail(scan.nextLine());
             System.out.println("Telefone: ");
             usuario.setTelefone(scan.nextLine());
             System.out.println("Endereço: ");
             usuario.setEndereco(scan.nextLine());

             System.out.println("");

            //Empresa
             System.out.println("Informe os dados da empresa!");
             System.out.println("Razão social: ");
             empresa.setRazaoSocial(scan.nextLine());
             System.out.println("Nome fantasia: ");
             empresa.setNomeFantasia(scan.nextLine());
             System.out.println("Cnpj: ");
             empresa.setCnpj(scan.nextLine());
             System.out.println("Email: ");
             empresa.setEmail(scan.nextLine());
             System.out.println("Telefone: ");
             empresa.setTelefone(scan.nextLine());
             System.out.println("Endereço: ");
             empresa.setEndereco(scan.nextLine());


             //Saída Usuario
             System.out.println("Dados usuario!:\n");
             System.out.println("Nome: " + usuario.getNome());
             System.out.println("Data de nascimento: " + usuario.getDataNascimento());
             System.out.println("Cpf: " + usuario.getCpf());
             System.out.println("Email: " + usuario.getEmail());
             System.out.println("Telefone: " + usuario.getTelefone());
             System.out.println("Endereço: " + usuario.getEndereco());
             System.out.println("");

            //Saída Empresa
             System.out.println("\nDados empresa!:\n");
             System.out.println("Razão social: " + empresa.getRazaoSocial());
             System.out.println("Nome fantasia: " + empresa.getNomeFantasia());
             System.out.println("Cnpj: " + empresa.getCnpj());
             System.out.println("Email: " + empresa.getEmail());
             System.out.println("Telefone: " + empresa.getTelefone());
             System.out.println("Endereço: " + empresa.getEndereco());
             
        scan.close();
    }
}
