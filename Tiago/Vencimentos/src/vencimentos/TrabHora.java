/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos;

/**
 *
 * @author i090674
 */
public class TrabHora extends Trabalhador {

    private int nHoras;
    private float pagHora;

    public TrabHora(String nome, int nH, float pH) throws ValorNegativo{
        super(nome);
        if(nH<0)
            throw new ValorNegativo();
        nHoras = nH;
        if(pH<0)
            throw new ValorNegativo();
        pagHora = pH;
    }

    public int getNHoras() { return nHoras; }
    public float getPagHora() { return pagHora; }

    public float vencimento() {
        return nHoras * pagHora;
    }

    public String toString() {
        return "Trab. à Hora : " + super.toString();
    }

}

