/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentoscomparable;

/**
 *
 * @author i090674
 */
public abstract class Trabalhador implements Comparable {

    private String nome;

    public Trabalhador(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public abstract float vencimento();

    public String toString() {
        return nome;
    }

   public int compareTo(Object o) {
        Trabalhador trab = (Trabalhador) o;
        int i= (int) (this.vencimento() - trab.vencimento());
        return i;
    }
}

