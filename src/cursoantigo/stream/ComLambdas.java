package cursoantigo.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComLambdas {
    public static void main(String[] args) {
        List<Gato> gatoes = new ArrayList<>() {{
            add(new Gato("felipe", "branco", 14));
            add(new Gato("tomas", "preto", 12));
            add(new Gato("gustava", "marrom", 13));
        }};
        gatoes.sort(Comparator.comparing((Function<Gato, String>) gato -> gato.getNome()));
        // entendi porra nenhuma desse lambda, sinceramente
    }
}
