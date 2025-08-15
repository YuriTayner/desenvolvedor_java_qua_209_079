package com.dialogos.app;

import javax.swing.JOptionPane;

import com.dialogos.model.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa usuario = new Pessoa(null, 0);
        usuario.setNome(JOptionPane.showInputDialog("Informe seu nome: "));
        usuario.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade: ")));

        JOptionPane.showMessageDialog(null, "Nome: " + usuario.getNome() + "\nIdade: " + usuario.getIdade(), "Saída", JOptionPane.OK_OPTION);
    }
}
