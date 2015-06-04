/*
 * Carta.java
 *
 * Created on 28 de Fevereiro de 2007, 14:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package exemplocomcartas;

/**
 *
 * @author Nuno Malheiro
 */
public abstract class Carta implements Comparable<Carta> {
// Tipos enumerados de possiveis cartas

    public static enum Tipo {

        Duque, Terno, Quadra, Quina, Sena,
        Oito, Nove, Dez, Dama, Valete, Rei, Manilha, As
    };
// Tipos enumerados de possiveis naipes

    public static enum Naipe {

        Copas, Ouros, Espadas, Paus
    };
    /* Tipo da instância de carta */
    private Tipo t;
    private Naipe n;

    /** Creates a new instance of Carta */
    public Carta(Tipo t, Naipe n) {
        this.t = t;
        this.n = n;
    }

    /** Cria uma nova carta baseada numa string. ex: "As de Ouros" */
    public Carta(String s) {
        String[] ls = s.split(" ");
        this.t = Tipo.valueOf(ls[0]);
        this.n = Naipe.valueOf(ls[2]);
    }

    /** Converte uma carta numa string. ex: "As de Ouros" */
    public String toString() {
        return t.toString() + " de " + n.toString();
    }

    /** Devolve o tipo da carta */
    public Tipo getTipo() {
        return t;
    }

    /** Devolve o naipe da carta */
    public Naipe getNaipe() {
        return n;
    }

    public int compareTo(Carta o) {
        int i = 0;
        if (this.getNaipe().compareTo(o.getNaipe()) < 0) {
            i = -1;
        } else if (this.getNaipe().compareTo(o.getNaipe()) == 0) {
            if (this.getTipo().compareTo(o.getTipo()) < 0) {
                i = -1;
            } else if (this.getTipo().compareTo(o.getTipo()) == 0) {
                i = 0;
            } else if (this.getTipo().compareTo(o.getTipo()) < 0) {
                i = -1;
            } else {
                i = 1;
            }
        } else {
            i = 1;
        }
        return i;
    }
}
