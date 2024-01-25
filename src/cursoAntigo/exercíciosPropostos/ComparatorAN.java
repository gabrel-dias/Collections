package cursoAntigo.exercíciosPropostos;

import java.util.Comparator;

public class ComparatorAN implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ano = Integer.compare(o1.getAnoCriacao(), o2.getAnoCriacao());
        if (ano != 0) return ano;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }

}
