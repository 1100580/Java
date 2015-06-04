
package figurasgeometricas;

import javax.swing.JOptionPane;

public class Esfera extends Circulo implements Figura3D {
    public Esfera (float raio, Cor cor) {
        super (raio, cor);
    }

    public Esfera() {
        super();
    }

    public String toString() {
        return String.format("Esfera: raio = %.1f - cor = %s ", getRaio(), getCor());
    }

    public static Esfera lerEsfera() {
        float raio = Float.parseFloat(JOptionPane.showInputDialog("Raio do círculo ?"));
        String cor = JOptionPane.showInputDialog("Cor do círculo ?");
        return new Esfera(raio, Cor.valueOf(cor.toUpperCase()));
    }

    public float area() {
        return 4 * super.area();
    }

    public float volume() {
        return (float)(4/3 * Math.PI * Math.pow(getRaio(), 3));
    }
}
