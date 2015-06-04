/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogo;

/**
 *
 * @author Gisela
 */
public class Jogadas {

    private int pilhaInicio;
    private int pilhaDestino;
    private Cartao c;

    public Jogadas(int pilhaInicio, int PilhaDestino, Cartao c){
        setPilhaInicio(pilhaInicio);
        setPilhaDestino(pilhaDestino);
        setC(c);

    }

    /**
     * @return the pilhaInicio
     */
    public int getPilhaInicio() {
        return pilhaInicio;
    }

    /**
     * @param pilhaInicio the pilhaInicio to set
     */
    public void setPilhaInicio(int pilhaInicio) {
        this.pilhaInicio = pilhaInicio;
    }

    /**
     * @return the pilhaDestino
     */
    public int getPilhaDestino() {
        return pilhaDestino;
    }

    /**
     * @param pilhaDestino the pilhaDestino to set
     */
    public void setPilhaDestino(int pilhaDestino) {
        this.pilhaDestino = pilhaDestino;
    }

    /**
     * @return the c
     */
    public Cartao getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cartao c) {
        this.c = c;
    }


}
