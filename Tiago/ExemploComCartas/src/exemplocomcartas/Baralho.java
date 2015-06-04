/*
 * Baralho.java
 *
 * Created on 28 de Fevereiro de 2007, 14:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package exemplocomcartas;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Nuno Malheiro
 */
public class Baralho extends ArrayList <Carta> {
    /** Tipo de Baralho (40 ou 52 cartas) */
    public static enum Tipo { BAR_40, BAR_52 };
    /** Creates a new instance of Baralho */
    public Baralho(Tipo tb) {
        for (Carta.Naipe n : Carta.Naipe.values())
            for (Carta.Tipo t : Carta.Tipo.values()) {
                if ((tb==Tipo.BAR_40) && (t.compareTo(Carta.Tipo.Sena) > 0) &&
                        (t.compareTo(Carta.Tipo.Dama) < 0)) continue;
                this.add(new Carta(t, n) {});
            }
    }
    /** Baralhar as cartas */
    public void baralhar() {
        /** Uso do método de baralho de java.util.Collections */
        Collections.shuffle(this);
    }
    /** Partir as cartas */
    public void partir() {
        /** Guarda primeira metade */
        ArrayList <Carta> mbar = new ArrayList <Carta>(this.subList(0,this.size()/2));
        /** Remove primeira metade */
        this.removeAll(mbar);
        /** Coloca no final a primeira metade */
        this.addAll(mbar);
    }
    /** Retira e devolve as primeiras n cartas do baralho */
    public ArrayList <Carta> primeirasCartas(int n) {
        /** Guarda as n primeiras */
        ArrayList <Carta> mbar = new ArrayList <Carta>(
                this.subList(0, ( n < this.size() ? n : this.size() ) ) );
        /** Remove as n primeiras */
        this.removeAll(mbar);
        return mbar;
    }
    /** Retira e devolve as ultimas n cartas do baralho */
    public ArrayList <Carta> ultimasCartas(int n) {
        /** Guarda as n ultimas */
        ArrayList <Carta> mbar = new ArrayList <Carta>(
                this.subList( (n > this.size() ? 0 : this.size()-n ), this.size() ) );
        /** Remove as n ultimas */
        this.removeAll(mbar);
        return mbar;
    }
    /** Converte um baralho numa string (uma carta por linha) */
    public String toString() {
        String s = "";
        for (Carta c : this) {
            s = s + c.toString() + "\n";
        }
        return s;
    }
}