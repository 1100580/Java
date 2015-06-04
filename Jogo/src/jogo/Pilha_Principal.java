/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;


import java.io.Serializable;
import jogo.Cartao.Numero;

/**
 *
 * @author Gisela
 */
public class Pilha_Principal extends Pilha implements Serializable {

    int numero_pilha;
    Numero [] n;

    public Pilha_Principal(Numero [] n) {
        super();
        this.n = n;
    }

    public boolean colocarCarta(Pilha pilha){
        if(pilha.peekFirst().getNumero() == n[this.size() - 1]){
            Cartao c  = pilha.pop();
            this.push(c);
            return true;
        }
        return false;
    }

     public boolean colocarCarta(Pilha pilha, int numcartabaralho){
         // se chamou este metodo e pk carta vem do baralho
         // decrementar um pk nesta altura o numcartas do baralho ja foi incrementado uma posicao
        numcartabaralho = numcartabaralho -1 ;
        if(pilha.get(numcartabaralho).getNumero() == n[this.size() - 1]){
            Cartao c  = pilha.get(numcartabaralho);
            this.push(c);
            return true;
        }
        return false;
    }

    public boolean cheia(){
        if(this.size() == 7){
            return true;
        }
        return false;
    }

}
