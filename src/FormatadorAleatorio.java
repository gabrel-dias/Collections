import java.text.NumberFormat;
import java.util.Locale;

 public class FormatadorAleatorio {
    public static void main(String[] args) {
        double numero = (Math.random()* 10); // o método Random retorna um número double aleatório entre 0 e 1
        // para definir o range do seu número aleatório, é preciso multiplicar o retorno de Random pelo número máximo
        // ex: int numeroAleatorio = min + (int)(Math.random() * (max - min));

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
