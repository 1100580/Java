package vencimentosComparavel;

public abstract class Trabalhador implements Comparavel {
    
    private String nome;
    
    public Trabalhador(String n) {
        nome = n;
    }
    
    public String getNome() { return nome; }
    
    public abstract float vencimento();
    
    public String toString() {
        return nome;
    }
    
    public boolean menor(Object obj) {
        Trabalhador t = (Trabalhador) obj;
        if( this.vencimento() < t.vencimento() )
            return true;
        return false;
    }
    
    public boolean igual(Object obj) {
        Trabalhador t = (Trabalhador) obj;
        if( this.vencimento() == t.vencimento() )
            return true;
        return false;
    }
    
    public boolean maior(Object obj) {
        Trabalhador t = (Trabalhador) obj;
        if( this.vencimento() > t.vencimento() )
            return true;
        return false;
    }

}
