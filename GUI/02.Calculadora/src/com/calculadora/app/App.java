package com.calculadora.app;

import javax.swing.JOptionPane;

import com.calculadora.controller.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {
        Calculadora calc = new Calculadora(0, 0);

        String[] opcoes = {"Somar", "Subtrair", "Multiplicar", "Dividir", "Sair"};
        Object opcao; 

        do{
            opcao = JOptionPane.showInputDialog(null, "Selecione uma opção: ", "Calculadora", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            
            if (opcao != "Sair") {
                calc.setX(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de X: ")));
                calc.setY(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de Y: ")));
            }

            if (opcao == "Somar") {
                JOptionPane.showMessageDialog(null, "O resultado da soma é " + calc.somar(calc.getX(), calc.getY()), "Soma", JOptionPane.INFORMATION_MESSAGE);
            } else if (opcao == "Subtrair") {
                JOptionPane.showMessageDialog(null, "O resultado da subtração é " + calc.subtrair(calc.getX(), calc.getY()), "Subtração", JOptionPane.INFORMATION_MESSAGE);
            } else if (opcao == "Multiplicar") {
                JOptionPane.showMessageDialog(null, "O resultado da multiplicação é " + calc.multiplicar(calc.getX(), calc.getY()), "Multiplicação", JOptionPane.INFORMATION_MESSAGE);
            } else if (opcao == "Dividir") {
                JOptionPane.showMessageDialog(null, "O resultado da divisão é " + calc.dividir(calc.getX(), calc.getY()), "Divisão", JOptionPane.INFORMATION_MESSAGE);
            }
        } while(opcao != "Sair");
    }
}
