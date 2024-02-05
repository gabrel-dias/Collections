package cursoantigo.exercíciospropostos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
public class ListExercicio2 {
    public static void main(String[] args) {
        List<String> respostasList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Perguntas sobre o crime (responder com 'S' ou 'N'): ");
        System.out.println("\nTelefonou para a vítima?");
        String respostasScan = scan.next();
        respostasList.add(respostasScan.toLowerCase());
        System.out.println("Esteve no local do crime?");
        respostasScan = scan.next();
        respostasList.add(respostasScan.toLowerCase());
        System.out.println("Mora perto da vítima?");
        respostasScan = scan.next();
        respostasList.add(respostasScan.toLowerCase());
        System.out.println("Devia para a vítima?");
        respostasScan = scan.next();
        respostasList.add(respostasScan.toLowerCase());
        System.out.println("Já trabalhou com a vítima?");
        respostasScan = scan.next();
        respostasList.add(respostasScan.toLowerCase());
        scan.close();

        System.out.println(respostasList);

        Iterator<String> iterator = respostasList.iterator();
        int cont = 0;
        while (iterator.hasNext()) {
            String resp = iterator.next();
            if (resp.contains("s")) {
                cont++;
            }
        }

        switch (cont) {
            case 2:
                System.out.println("SUSPEITO");
                break;
            case 3:
            case 4:
                System.out.println("CÚMPLICE");
                break;
            case 5:
                System.out.println("ASSASSINO");
                break;
            default:
                System.out.println("INOCENTE");
                break;
        }

    }

}
