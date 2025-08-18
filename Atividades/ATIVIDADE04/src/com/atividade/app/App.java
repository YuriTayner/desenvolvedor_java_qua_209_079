package com.atividade.app;

import javax.swing.JOptionPane;

import com.atividade.model.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa(null, 0, 0, 0);
        String[] opcoes = {"Iniciar", "Sair"};
        Object opcao;

        do{
            opcao = JOptionPane.showInputDialog(null, "Selecione uma opção: ", "Calculadora de IMC", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            
            if (opcao != "Sair") {
                pessoa.setNome(JOptionPane.showInputDialog("Qual o seu nome? "));
                pessoa.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe seu peso (kg): ")));
                pessoa.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Informe sua altura (M): ")));
            } else{
                break;
            }

            JOptionPane.showMessageDialog(null, "Imc: " + pessoa.calcularImc(pessoa.getPeso(), pessoa.getAltura(), 0));
           
            JOptionPane.showMessageDialog(null, "" + pessoa.indicarImc(pessoa.getNome(), pessoa.calcularImc(pessoa.getPeso(), pessoa.getAltura(), 0)));
        } while(opcao != "Sair");
    }
}
