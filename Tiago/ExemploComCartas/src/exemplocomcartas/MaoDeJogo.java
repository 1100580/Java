/*
 * MaoDeJogo.java
 *
 * Created on 28 de Fevereiro de 2007, 14:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package exemplocomcartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nuno Malheiro
 */
public class MaoDeJogo extends ArrayList<Carta> {

    /**
     * Creates a new instance of MaoDeJogo
     */
    public MaoDeJogo(ArrayList<Carta> l) {
        super(l);
    }

    public ArrayList<Carta.Tipo> tiposDeCarta() {
        ArrayList<Carta.Tipo> a = new ArrayList<Carta.Tipo>();
        for (Carta o : this) {
            if (!a.contains(o.getTipo())) {
                a.add(o.getTipo());
            }
        }
        return a;
    }

    public int contarCartasDoTipo(Carta.Tipo t) {
        int n=0;
        for (Carta c : this) {
            if(c.getTipo().equals(t))
                n++;
        }
        return n;
    }

    public void ordenar() {
       Collections.sort(this);
    }
}
