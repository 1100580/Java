
package impostos;

public class TrabContOutr extends Contribuinte {

    private static float taxaRT1 = 0.01f;
    private static float taxaRT2 = 0.02f;
    private static float taxaOR = 0.02f;
    private String empresa = "";

    public TrabContOutr(String nome, String morada, String empresa, float rt, float or){
        super(nome, morada, rt, or);
        setEmpresa(empresa);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public float taxaRT(){
        if (getRt() <= 30000 && getRt() >= 0) {
            return taxaRT1;
        }
        return taxaRT2;
    }

    @Override
    public String toString() {
        return String.format("Trabalhador por conta de outrém: Imposto total = ") + calcularImposto();
    }

    @Override
    public float taxaOR() {
        return 0;
    }
}
