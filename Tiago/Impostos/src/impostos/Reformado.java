/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author i090674
 */
public class Reformado extends Contribuinte {

    public Reformado(String n, String m, float rt, float or) {
        super(n, m, rt, or);
    }

    public float imposto() {
        return ((float) (RT * 0.01 + OR * 0.03));
    }

    public String toString() {
        String s = nome + ", Rendimentos de Trabalho= " + RT +", Outros Rendimentos= " + OR;
        return s;
    }
}
