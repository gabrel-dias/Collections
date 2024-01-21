package exercícios.list.pesquisa;

public class Livro {
    // atributos
    private String titulo;
    private String autor;
    private int anoPublicacao;

    // construtor para que toda vez que um construtor do tipo livro seja criado,
    // seja necessário passar todos esses parâmetros
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // getters pois os atributos estão como private
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override // sobrecarga para mostrar os itens da lista e não seu endereço na memória
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + "]";
    }

}
