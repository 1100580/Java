package vencimentosComparable;

public class TrabPeca extends Trabalhador {
    
    private int nPecas;
    private float pagPeca;
    
    public TrabPeca(String nome, int nP, float pP) {
        super(nome);
        nPecas = nP;
        pagPeca = pP;
    }
    
    public int getNPecas() { return nPecas; }
    public float getPagPeca() { return pagPeca; }
    
    public float vencimento() {
        return nPecas * pagPeca;
    }
    
    public String toString() {
        return "Trab. à Peça : " + super.toString();
    }
    
}
