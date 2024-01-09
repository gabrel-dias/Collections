package MeusExercícios.ExercíciosPropostos;
/*Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<TemperaturaMeses> temperaturaList = new ArrayList<TemperaturaMeses>();
        // Adicionando as temperaturas na lista
        for (int cont = 0; cont<6; cont++) {
            System.out.println("Digite as temperaturas respectivas de Janeiro a Junho: ");
            double temperaturaScan = scan.nextDouble();
            temperaturaList.add(new TemperaturaMeses(temperaturaScan));
        }
        System.out.println();
        scan.close();
    }
}

class TemperaturaMeses {
    private String mes;
    private double temp;

    // construtor com temperatura
    public TemperaturaMeses(double temp) {
        this.temp = temp;
    }

    // construtor com mês e temperatura
    public TemperaturaMeses(String mes, double temp) {
        this.mes = mes;
        this.temp = temp;
    }


    public String getMes() {
        return mes;
    }

    public double getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "TemperaturaMeses [mes=" + mes + ", temp=" + temp + "]";
    }

}