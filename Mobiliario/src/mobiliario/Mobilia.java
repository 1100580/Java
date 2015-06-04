
package mobiliario;

public abstract class Mobilia {

    private static int numIDSet;
    private int numID;
    private double preco, peso;

    public Mobilia(double preco, double peso){
        setPreco(preco);
        setPeso(peso);
        numID = numIDSet++;
    }

    public int getNumID() {
        return numID;
    }

    public abstract void aumentaPreco(double percent);
    public abstract String toString();

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
