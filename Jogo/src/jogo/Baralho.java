/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogo;

import java.util.Collections;

/**
 *
 * @author Gisela
 */
public class Baralho extends Pilha{

    public Baralho(){
        super();
        for(Cartao.Cor cor : Cartao.Cor.values()){
            for (Cartao.Numero numero : Cartao.Numero.values()) {
                Cartao c = new Cartao(numero, cor);
                this.addLast(c);
              

            }
        }
        for(int i = 0; i < 2; i++){
            Collections.shuffle(this);
        }
    }



}
