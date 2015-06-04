

package impostos;

public abstract class Contribuinte {

    private String nome;
    private String morada;
    private float rt;
    private float or;

    public Contribuinte(String nome, String morada, float rt, float or){
        setNome(nome);
        setMorada(morada);
        setRt(rt);
        setOr(or);
    }

    public float getOr() {
        return or;
    }

    public void setOr(float or) {
        this.or = or;
    }

    public float getRt() {
        return rt;
    }

    public void setRt(float rt) {
        this.rt = rt;
    }

    public float calcularImposto(){
        return rt*taxaRT() + or*taxaOR();
    }

    public abstract float taxaRT();

    public abstract float taxaOR();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public abstract String toString();
}
