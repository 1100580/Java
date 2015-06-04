
package figurasgeometricas;

public abstract class Figura implements Comparable {
    private Cor cor;

    public Figura(Cor cor) {
        setCor(cor);
    }

    public Figura() {
        this(Cor.AZUL);
    }

    public abstract float area();

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String toString() {
        return String.format("cor = %s", cor);
    }

    public int compareTo(Object obj) {
        if (area() < ((Figura) obj).area())
            return -1;
        else if (area() == ((Figura) obj).area())
            return 0;
        else
            return 1;
    }
}
