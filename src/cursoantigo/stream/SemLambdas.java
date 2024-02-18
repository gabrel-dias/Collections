package cursoantigo.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SemLambdas {
    public static void main(String[] args) {
        List<Gato> gatoes = new ArrayList<>() {
            {
                add(new Gato("felipe", "branco", 14));
                add(new Gato("tomas", "preto", 12));
                add(new Gato("gustava", "marrom", 13));
            }
        };
        gatoes.sort(Comparator.comparing(new Function<Gato, String>() { // utiliza o método comparing da interface
                                                                        // Comparator, que precisa da implementação da
                                                                        // interface Function(???), que tem o método
                                                                        // apply()
            @Override
            public String apply(Gato gato) {
                return gato.getNome();
            }
        }));
    }
}
