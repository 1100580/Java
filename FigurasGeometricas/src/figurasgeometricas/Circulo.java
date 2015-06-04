
package figurasgeometricas;

import javax.swing.JOptionPane;

public class Circulo extends Figura {

    private float raio;

    public Circulo(float raio, Cor cor) throws ValorNuloOuNegativoException {
        super(cor);
        setRaio(raio);
    }

    public Circulo() throws ValorNuloOuNegativoException {
        super();
        setRaio(1);
    }

    public float area() {
        return (float) Math.PI * raio * raio;
    }

    public String toString() {
        return String.format("Círculo: raio = %.1f - %s ", raio, super.toString());
    }

    public static Circulo lerCirculo() throws ValorNuloOuNegativoException {
        float raio = Float.parseFloat(JOptionPane.showInputDialog("Raio do círculo ?"));
        String cor = JOptionPane.showInputDialog("Cor do círculo ?");
        return new Circulo(raio, Cor.valueOf(cor.toUpperCase()));
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) throws ValorNuloOuNegativoException {
        if (raio > 0) {
            this.raio = raio;
        } else{
            throw new ValorNuloOuNegativoException();
        }
    }
}
