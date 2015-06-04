package fichamodelo;

public class Livros extends Produto{

    private String autor;

    public Livros(String nome, float custo, String autor){
        super(nome,custo);
        setAutor(autor);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String toString(){
        return String.format(super.toString(),"Autor: ", autor);
    }

}