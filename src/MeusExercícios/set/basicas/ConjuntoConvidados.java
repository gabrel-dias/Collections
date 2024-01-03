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

    // TODO entender porque esse método não está rodando
    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoRemover = null;
        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidadoRemover = c;
                break;
            }
            convidadoSet.remove(convidadoRemover);
        }
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        for (Convidado c : convidadoSet) {
            System.out.println(c);
        }
    }
//TODO treinar ordenação por código do convidado
    public void ordenar(int codigoConvidado) {

    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();

        convidados.adicionarConvidado("gabrel", 23);
        convidados.adicionarConvidado("brune", 22);
        convidados.adicionarConvidado("predo", 16);
        convidados.adicionarConvidado("luzia", 85);

        convidados.exibirConvidados();
        convidados.removerConvidadoPorCodigoConvite(85);
        System.out.println("");
        convidados.exibirConvidados();

    }
}
