
package figurasgeometricas;

import javax.swing.JOptionPane;

public class Quadrado extends Rectangulo {

    public Quadrado(float lado, Cor cor) {
        super(lado, lado, cor);
    }

    public Quadrado() {
        super();
    }

    @Override
    public void setCompr(float compr) {
        super.setCompr(compr);
        super.setLarg(compr);
    }

    public void setLarg(float larg) {
        super.setLarg(larg);
        super.setCompr(larg);
    }

    public String toString() {
        return String.format("Quadrado: lado  = %.1f - cor: %s", getCompr(), getCor());
    }

    public static Quadrado lerRectangulo() {
        float lado = Float.parseFloat(JOptionPane.showInputDialog("Lado do quadrado ?"));
        String cor = JOptionPane.showInputDialog("Cor do quadrado ?");
        return new Quadrado(lado, Cor.valueOf(cor.toUpperCase()));
    }
}








