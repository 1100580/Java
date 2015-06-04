
package mobiliario;

public class Mesa extends Mobilia {

    private int capacidade;
    public Mesa(double preco, double peso, int capacidade){
        super(preco, peso);
        setCapacidade(capacidade);
    }

    public void aumentaPreco(double percent){
        super.setPreco(super.getPreco() + super.getPreco()*(percent/100));
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String toString(){
        return String.format("Mesa(numID:" + getNumID() + ") Preço: " + getPreco() + " euros, Peso: " + getPeso() + " quilos, capacidade para " + capacidade + " pessoas.");
    }
}
