package com.atividade06.app;

import javax.swing.JOptionPane;

import com.atividade06.model.Carro;
import com.atividade06.model.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa usuario = new Pessoa(null, null, null, null, null, null);
        Carro veiculo = new Carro(null, null, null, null, usuario);

        usuario.setNome(JOptionPane.showInputDialog("Insire o nome do proprietário do carro:"));
        usuario.setCpf(JOptionPane.showInputDialog("Insire o cpf do proprietário do carro:"));
        usuario.setTelefone(JOptionPane.showInputDialog("Insire o telefone do proprietário do carro:"));
        usuario.setEndereco(JOptionPane.showInputDialog("Insire o endereço do proprietário do carro:"));
        usuario.setEmail(JOptionPane.showInputDialog("Insire o E-mail do proprietário do carro:"));
        usuario.setDataNascimento(JOptionPane.showInputDialog("Insira a data de nascimento do proprietário do carro:"));

        veiculo.setFabricante(JOptionPane.showInputDialog("Agora insira o fabricante de seu carro:"));
        veiculo.setModelo(JOptionPane.showInputDialog("Insire o modelo de seu carro:"));
        veiculo.setAno(JOptionPane.showInputDialog("Insire o ano de seu carro:"));
        veiculo.setCor(JOptionPane.showInputDialog("Insira a cor de seu carro:"));

        JOptionPane.showMessageDialog(null, veiculo.exibirDados(), "Dados do carro", 0);
    }
}
