/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author i090674
 */
public class TrabOutrem extends Contribuinte {

    private String nomeempresa;

    public TrabOutrem(String n, String m, float rt, float or, String nm) {
        super(n, m, rt, or);
        nomeempresa = nm;
    }

    public float imposto() {
        if (RT <= 30000) {
            return ((float) (RT * 0.01 + OR * 0.02));
        } else {
            return ((float) (RT * 0.02 + OR * 0.02));
        }
    }

    public String toString() {
        String s = nome + ", Rendimentos de Trabalho= " + RT + ", Outros Rendimentos= " + OR + " e trabalha na empresa "+nomeempresa;
        return s;
    }
}
