/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author i090674
 */
public class TrabPropria extends Contribuinte {

    private String profissao;

    public TrabPropria(String n, String m, float rt, float or, String p) {
        super(n, m, rt, or);
        profissao = p;
    }

    public float imposto() {
        if (OR <= 50000) {
            return ((float) (RT * 0.03 + OR * 0.02));
        } else {
            return ((float) (RT * 0.03 + OR * 0.05));
        }
    }

    public String toString() {
        String s = nome + ", é "+profissao+ ", Rendimentos de Trabalho= " + RT + ", Outros Rendimentos= " + OR;
        return s;
    }
}
