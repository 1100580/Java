
package impostos;

public class Reformado extends Contribuinte {

    private static float taxaRT = 0.01f;
    private static float taxaOR = 0.03f;

    public Reformado(String nome, String morada, float rt, float or){
        super(nome, morada, rt, or);
    }

    @Override
    public String toString() {
        return String.format("Reformado: Imposto total = ") + calcularImposto();
    }

    @Override
    public float taxaRT() {
        return taxaRT;
    }

    @Override
    public float taxaOR() {
        return taxaOR;
    }
}