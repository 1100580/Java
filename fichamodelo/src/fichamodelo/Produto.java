package fichamodelo;

public class Produto {

    private static float livros = 0.5f;
    private static float softwares = 0.10f;
    private String nome;
    private float custo;

    public Produto(String nome, float custo) {
        setNome(nome);
        setCusto(custo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float PrecoVendaLivros(){
        return (getCusto() + livros);
    }

    public float PrecoVendaSoftwares(){
        return (getCusto() + softwares);
    }

    public String toString() {
        return String.format("Nome: " + nome + "Custo: " + custo + "€");
    }
}