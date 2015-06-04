
package agendatelefonica;

public  abstract class Entrada {
    private String nome;
    private int telefone;

    public Entrada(String nome, int telefone){
        setNome(nome);
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public abstract String toString();

}