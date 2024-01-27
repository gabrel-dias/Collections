import java.util.Scanner;

public class Brune {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("A Bruna é gostosa?");
        String respostaGostosa = scan.next();
        scan.close();
        if (respostaGostosa.equals("s")) {
            System.out.println("Sim, a Bruna é gostosa");
        }
        else
        System.out.println("Acho que você está mentindo...");

    }
}