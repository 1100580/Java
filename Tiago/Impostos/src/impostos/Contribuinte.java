/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author i090674
 */
public abstract class Contribuinte {

    protected String nome;
    protected String morada;
    protected float RT;
    protected float OR;

    public Contribuinte(String n, String m, float rt, float or) {
        nome = n;
        morada = m;
        RT = rt;
        OR = or;
    }
    public abstract float imposto();

    public abstract String toString();
}
