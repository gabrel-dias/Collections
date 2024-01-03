package MeusExercícios.set.basicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    // atributo
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvidado) {
        convidadoSet.add(new Convidado(nome, codigoConvidado));

    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoRemover = null;
        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidadoRemover = c;
                break;
            }
        }
    }

}
