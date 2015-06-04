
package mobiliario;

public class Cadeira extends Mobilia {

    private boolean encosto;

    public Cadeira(double preco, double peso, boolean encosto){
        super(preco, peso);
        setEncosto(encosto);
    }
    
    public void aumentaPreco(double percent){
        super.setPreco(super.getPreco() + super.getPreco()*(percent/100));
    }

    public boolean getEncosto() {
        return encosto;
    }

    public void setEncosto(boolean encosto) {
        this.encosto = encosto;
    }

    public String toString(){
        return String.format("Cadeira(numID:" + getNumID() + ") Preço: " + getPreco() + " euros, Peso: " + getPeso() + ((getEncosto()) ? " quilos, com encosto." : " quilos, sem encosto."));
    }
}
