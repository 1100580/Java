
package impostos;

public class Desempregado extends Contribuinte {

    private static float taxaOR = 0.03f;
    private int mesesParagem = 0;


    public Desempregado(String nome, String morada, int mesesParagem, float rt, float or){
        super(nome, morada, rt, or);
        setMesesParagem(mesesParagem);
        taxaOR();
    }

    public void setMesesParagem(int mesesParagem){
        this.mesesParagem = mesesParagem;
    }

    public float taxaOR(){
        return taxaOR;
    }

    @Override
    public float taxaRT() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Deempregado: Imposto total = ") + calcularImposto();
    }
}
