/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author i090674
 */
public class Desempregado extends Contribuinte {

    private int mesesParagem;

    public Desempregado(String n, String m, float rt, float or, int mp) {
        super(n, m, rt, or);
        mesesParagem = mp;
    }

    public float imposto() {
        return ((float) (OR * 0.02));
    }

    public String toString(){
        String s= nome+", Outros Rendimentos= "+OR+", está parado há "+mesesParagem+ " meses";
        return s;
    }
}
