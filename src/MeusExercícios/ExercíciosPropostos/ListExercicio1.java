package MeusExercícios.ExercíciosPropostos;
/*Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListExercicio1 {
    public static void main(String[] args) {
        List<Double> temperaturaList = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        // Adicionando as temperaturas na lista
        for (int cont = 0; cont < 6; cont++) {
            System.out.println("Digite as temperaturas respectivas de Janeiro a Junho: ");
            double temperaturaScan = scan.nextDouble();
            temperaturaList.add(temperaturaScan);
        }
        scan.close();
        // calculando a média das temperaturas
        double soma = 0d;
        for (Double temperatura : temperaturaList)
            soma += temperatura;
        double media = soma / temperaturaList.size();// o método size() retorna o valor de todos os valores armazenados
                                                     // na lista, que no caso é 6 e nisso é divido com a soma dos
                                                     // valores passados no forEach, tirando assim a sua média
        System.out.printf("A média das temperaturas dos meses é: %.1f\n", media);

        // filtrando as temperaturas pela média
        System.out.println("Meses nos quais as suas temperaturas foram acima da média semestral: ");
        // eu não vou mentir, nessa parte aqui eu não entendi quase nada pq não estudei
        // esse iterator direito ainda, mas seguimos em frente pra terminar a caramba
        // desse exercício
        Iterator<Double> iterator = temperaturaList.iterator();
        int cont = 0;
        while (iterator.hasNext()) {
            Double temp = iterator.next();
            if (temp > media) {
                switch (cont) {
                    case (0):
                        System.out.printf("1 - janeiro: %.1f\n ", temp);
                        break;
                    case (1):
                        System.out.printf("2 - fevereiro: %.1f\n", temp);
                        break;
                    case (2):
                        System.out.printf("3 - março: %.1f\n", temp);
                        break;
                    case (3):
                        System.out.printf("4 - abril: %.1f\n", temp);
                        break;
                    case (4):
                        System.out.printf("5 - maio: %.1f\n", temp);
                        break;
                    case (5):
                        System.out.printf("6 - junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média.");
                }
            }
            cont++;
        }
    }
}
