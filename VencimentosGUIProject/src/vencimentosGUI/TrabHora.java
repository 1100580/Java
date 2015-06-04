package vencimentosGUI;

public class TrabHora extends Trabalhador {
    
    private int nHoras;
    private float pagHora;
    
    public TrabHora(String nome, int nH, float pH) {
        super(nome);
        nHoras = nH;
        pagHora = pH;
    }
    
    public int getNHoras() { return nHoras; }
    public float getPagHora() { return pagHora; }
    
    public float vencimento() {
        return nHoras * pagHora;
    }
    
    public String toString() {
        return "Trab. à Hora : " + super.toString();
    }
    
}
