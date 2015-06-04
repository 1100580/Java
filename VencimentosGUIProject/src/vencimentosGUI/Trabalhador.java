package vencimentosGUI;

public abstract class Trabalhador {
    
    private String nome;
    
    public Trabalhador(String n) {
        nome = n;
    }
    
    public String getNome() { return nome; }
    
    public abstract float vencimento();
    
    public String toString() {
        return nome;
    }
    
}
