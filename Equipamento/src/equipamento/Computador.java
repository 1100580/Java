
package equipamento;

public class Computador extends Equipamento {

    private String tipoProcessador;

    public Computador(String marca, String modelo, float precoCusto, String tipoProcessador){
        super(marca, modelo, precoCusto);
        setTipoProcessador(tipoProcessador);
    }
    
    @Override
    public boolean estaEmPromocao() {
        return false;
    }

    @Override
    public String toString() {
        return "Computador " + getMarca() + " " + getModelo() + ", processador " + getTipoProcessador() + ". Preço: " + super.precoVenda();
    }

    public String getTipoProcessador() {
        return tipoProcessador;
    }

    public void setTipoProcessador(String tipoProcessador) {
        this.tipoProcessador = tipoProcessador;
    }

}
