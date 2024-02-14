import java.text.NumberFormat;
import java.util.Locale;

 public class TesteFormatador {
    public static void main(String[] args) {
        double numero = 9616621.0;
        NumberFormat formatador = NumberFormat.getInstance(Locale.getDefault());
        /*
         * NumberFormat is the abstract base class for all number formats. This class
         * provides the interface for formatting and parsing numbers. NumberFormat also
         * provides methods for determining which locales have number formats, and what
         * their names are.
         */
        String numeroFormatado = formatador.format(numero); // a variável que irá receber o método formatador precisa
                                                            // ser uma string, pois em Java, não é permitido que se use
                                                            // pontos como separadores de milhares
        System.out.println("Número sem formatação: " + numero);
        System.out.println("Número com formatação: " + numeroFormatado);
    }
}
