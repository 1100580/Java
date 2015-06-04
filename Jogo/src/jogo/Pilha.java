/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogo;


import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Gisela
 */

public class Pilha extends LinkedList<Cartao> implements Serializable {
  
    private LinkedList<Cartao> pilha;
    private static int num = 0;
    private int id;
    public Pilha ()
    {
        num++;
        this.id = num;
        pilha = new LinkedList<Cartao>();
    }

    /**
     * @return the pilha
     */
    public LinkedList<Cartao> getPilha() {
        return pilha;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
