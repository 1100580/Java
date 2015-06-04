/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

import javax.swing.JOptionPane;

public class Paralelepipedo extends Rectangulo implements Figura3D {

    private float altura;

    public Paralelepipedo(float compr, float larg, float alt, Cor cor) {
        super(compr, larg, cor);
        setAltura(alt);
    }

    public Paralelepipedo() {
        super();
        setAltura(1);
    }

    public String toString() {
        return String.format("Paralepipedo: %s - altura = %.1f", super.toString(), altura);
    }

    public float area() {
        return 2 * (super.area() + getCompr() * getAltura() + getLarg() * getAltura());
    }

    public float volume() {
        return super.area() * altura;
    }

    //
    public static Paralelepipedo lerRectangulo() {
        float compr = Float.parseFloat(JOptionPane.showInputDialog("Comprimento do paralelepipedo ?"));
        float larg = Float.parseFloat(JOptionPane.showInputDialog("Largura do paralelepipedo ?"));
        float alt = Float.parseFloat(JOptionPane.showInputDialog("Altura do paralelepipedo ?"));
        String cor = JOptionPane.showInputDialog("Cor do paralelepipedo ?");
        return new Paralelepipedo(compr, larg, alt, Cor.valueOf(cor.toUpperCase()));
    }
    //

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = (altura > 0) ? altura : 1;
    }
}
