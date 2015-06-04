
package vencimentos;

public class TrabHora extends Trabalhadores{

    private int numHor;
    private float ganHor;

    public TrabHora(String nome, int nH, float gH) throws ValorNegativo{
        super(nome);
        if (nH < 0 || gH < 0) {
            throw new ValorNegativo();
        } else{
            numHor = nH;
            ganHor = gH;
        }
        
    }

    public float vencimento(){
        return numHor * ganHor;
    }
    public String toString() {
        return "Trabalhador à hora: " + super.toString();
    }

}