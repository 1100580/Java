/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentos;

/**
 *
 * @author i090674
 */
public abstract class Trabalhador implements Comparavel {

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

    public boolean menor(Object obj) {
        boolean b = false;
        Trabalhador trab = (Trabalhador) obj;
        if (this.vencimento() < trab.vencimento()) {
            b = true;
        }
        return b;
    }

    public boolean maior(Object obj) {
        boolean b = false;
        Trabalhador trab = (Trabalhador) obj;
        if (this.vencimento() > trab.vencimento()) {
            b = true;
        }
        return b;
    }

    public boolean igual(Object obj) {
        boolean b = false;
        Trabalhador trab = (Trabalhador) obj;
        if (this.vencimento() == trab.vencimento()) {
            b = true;
        }
        return b;
    }
}

