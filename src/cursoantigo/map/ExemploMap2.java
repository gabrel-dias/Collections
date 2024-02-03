package cursoantigo.map;

import java.util.HashMap;
import java.util.Map;

public class ExemploMap2 {
    public static void main(String[] args) {
        Map<String, Livro> livrosAleatorios = new HashMap<>() {
            {
                put("Stephen King", new Livro("IT: A coisa", 1104));
                put("George R.R. Martin", new Livro("A Tormenta de Espadas", 832));
                put("J.K. Rowling", new Livro("Harry Potter e a Pedra Filosofal", 208));
            }
        };

        System.out.println("--\tOrdem aleatória\t--");
        for (Map.Entry<String, Livro> livro : livrosAleatorios.entrySet()) {
            System.out.println(livro.getKey() + "\n" + livro.getValue().getTitulo()); // o getter do
                                                                                      // título vem do atributo da
                                                                                      // classe 'Livro'
        }
    }
}

class Livro {
    private String titulo;
    private int quantidadePaginas;

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public Livro(String titulo, int quantidadePaginas) {
        this.titulo = titulo;
        this.quantidadePaginas = quantidadePaginas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + quantidadePaginas;
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
        Livro other = (Livro) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (quantidadePaginas != other.quantidadePaginas)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Título - " + titulo + ", Páginas - " + quantidadePaginas;
    }

}
