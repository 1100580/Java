
package impostos;

public class TrabContProp extends Contribuinte {

    private static float taxaRT = 0.03f;
    private static float taxaOR1 = 0.02f;
    private static float taxaOR2 = 0.05f;
    private String profissao = "";

    public TrabContProp(String nome, String morada, String profissao, float rt, float or){
        super(nome, morada, rt, or);
        setProfissao(profissao);
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public float taxaRT(){
        return taxaRT;
    }

    @Override
    public float taxaOR(){
        if (getOr() <= 50000 && getOr() >= 0) {
            return taxaOR1;
        }
        return taxaOR2;
    }


    @Override
    public String toString() {
        return String.format("Trabalhador por conta própria: Trabalhador por conta de outrém:Imposto total = ") + calcularImposto();
    }

}
