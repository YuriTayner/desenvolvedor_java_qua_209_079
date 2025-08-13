package com.polimorfismo.app;

public class PessoaJuridica extends Pessoa{
    public String razãoSocial;
    public String nomeFantasia;
    public String cnpj;


    public PessoaJuridica(String razãoSocial, String nomeFantasia, String cnpj, String email, String telefone, String endereco) {
        super(email, telefone, endereco);
        this.razãoSocial = razãoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String cumprimentar(){
        return "Olá, somos da empresa " + this.nomeFantasia + ", de razão social " + this.razãoSocial + " cujo CNPJOTO é " + this.cnpj + ". Nosso e-mail é " + this.email
         + ", nosso telefone de contato é " + this.telefone + " e nosso endereço é " + this.endereco + ".";
    }

}
