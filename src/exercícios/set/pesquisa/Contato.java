package exercícios.set.pesquisa;

public class Contato {
    private String nome;
    private int numeroDeTelefone;

    public Contato(String nome, int numeroDeTelefone) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeTelefone(int numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", numeroDeTelefone=" + numeroDeTelefone + "]";
    }

    public Contato(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
//TODO entender qual a diferença desses dois conjuntos (acima e abaixo) de hashCode e de equals
//     @Override
//     public int hashCode() {
//         return Objects.hash(getNome());
//     }


//     @Override
//   public boolean equals(Object o) {
//     if (this == o) return true;
//     if (!(o instanceof Contato contato)) return false;
//     return Objects.equals(getNome(), contato.getNome());
//   }


   
}
