
package equipamento;

public abstract class Equipamento {

    private static int numId = 0;
    private int referencia;
    private String marca, modelo;
    private float precoCusto;

    public Equipamento(String marca, String modelo, float precoCusto){
        referencia = numId++;
        setMarca(marca);
        setModelo(modelo);
        setPrecoCusto(precoCusto);
    }

    public abstract boolean estaEmPromocao();

    public float precoVenda(){
        if (estaEmPromocao()) {
            return getPrecoCusto() + getPrecoCusto()*0.21f + getPrecoCusto()*0.05f;
        }else {
            return getPrecoCusto() + getPrecoCusto()*0.21f + getPrecoCusto()*0.2f;
        }
    }

    @Override
    public abstract String toString();

    public int getReferencia() {
        return referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }
}
