
package figurasgeometricas;

import javax.swing.JOptionPane;

public class Rectangulo extends Figura {

    private float compr, larg;

    public Rectangulo(float compr, float larg, Cor cor) {
        super(cor);
        setCompr(compr);
        setLarg(larg);
    }

    public Rectangulo() {
        super();
        setCompr(1);
        setLarg(1);
    }

    public String toString() {
        return String.format("comprimento = %.1f - largura = %.1f - %s", compr, larg, super.toString());
    }

    public float area() {
        return compr * larg;
    }

    public float getCompr() {
        return compr;
    }

    public static Rectangulo lerRectangulo() {
        float compr = Float.parseFloat(JOptionPane.showInputDialog("Comprimento do rectângulo ?"));
        float larg = Float.parseFloat(JOptionPane.showInputDialog("Largura do rectângulo ?"));
        String cor = JOptionPane.showInputDialog("Cor do rectângulo ?");
        return new Rectangulo(compr, larg, Cor.valueOf(cor.toUpperCase()));
    }

    public float getLarg() {
        return larg;
    }

    public void setLarg(float larg) {
        this.larg = (larg > 0) ? larg : 1;
    }

    public void setCompr(float compr) {
        this.compr = (compr > 0) ? compr : 1;
    }
}
