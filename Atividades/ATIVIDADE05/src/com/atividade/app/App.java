package com.atividade.app;

import javax.swing.JOptionPane;

import com.atividade.model.Combustivel;

public class App {
    public static void main(String[] args) throws Exception {
        //Crie um app para verificar qual o melhor combustível para um carro flex abastecer.
        //Note: compensa mais abastecer com etanol caso o valor dele seja até 70% do valor da gasolina.

        Combustivel ipiranga = new Combustivel(0, 0, 0);
        String[] opcoes = {"Iniciar", "Sair"};
        Object opcao;
        do{
            opcao = JOptionPane.showInputDialog(null, "Selecione uma opção: ", "Compensa comprar Etanol?", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if(opcao != "Sair"){
                ipiranga.setPrecoGasolina(Double.parseDouble(JOptionPane.showInputDialog("Informe o preço da gasolina(R$)").replace(",", ".")));
                ipiranga.setPrecoEtanol(Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do etanol(R$)").replace(",", ".")));
                
                ipiranga.compararCombustivel();

                JOptionPane.showMessageDialog(null, ipiranga.etanolCompensa());
            } else {
                break;
            }

        } while(opcao != "Sair");
    }
}
