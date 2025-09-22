package com.atividade09.app;

import javax.swing.JOptionPane;

import com.atividade09.model.Multa;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("OKOK");
        Multa pardal = new Multa();
        String[] opcoes = { "Iniciar", "Sair" };
        Object opcao;

        do {
            opcao = JOptionPane.showInputDialog(null, "Selecione uma opção: ", "Sistema de pardal",
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (opcao != "Sair") {
                pardal.setFabricante(JOptionPane.showInputDialog("Qual o nome do fabricante? "));
                pardal.setModelo(JOptionPane.showInputDialog("Qual o nome do modelo? "));
                pardal.setPlaca(JOptionPane.showInputDialog("Qual o nome do proprietario? "));
                pardal.setDist(Double.parseDouble(JOptionPane.showInputDialog("Informe a distância(Km/h): ")));
                pardal.setTempo(Double.parseDouble(JOptionPane.showInputDialog("Informe o tempo (Minutos): ")));
                pardal.calcularMulta();
                JOptionPane.showMessageDialog(null, pardal.resultadoMulta());
            } else {
                break;
            }
        } while (opcao != "Sair");
    }
}
