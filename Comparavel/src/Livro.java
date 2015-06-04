public class Livro implements Comparavel {

    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String toString() {
        return "Título: " + titulo + " Autor: " + autor;
    }

    public boolean igual(Object obj) {
        if (obj instanceof Livro)
            return titulo.compareToIgnoreCase(((Livro) obj).titulo) == 0;
        else 
            return false;
    }
}
