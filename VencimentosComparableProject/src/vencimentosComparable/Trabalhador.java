package vencimentosComparable;

public abstract class Trabalhador implements Comparable {
    
    private String nome;
    
    public Trabalhador(String n) {
        nome = n;
    }
    
    public String getNome() { return nome; }
    
    public abstract float vencimento();
    
    public String toString() {
        return nome;
    }
    
    public int compareTo(Object obj) {
        Trabalhador t = (Trabalhador) obj;
        if( this.vencimento() < t.vencimento() )
            return -1;
        else if (this.vencimento() == t.vencimento())
            return 0;
        else
            return 1;
    }

}
