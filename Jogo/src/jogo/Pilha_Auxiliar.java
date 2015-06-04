/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogo;

import java.io.Serializable;

/**
 *
 * @author Gisela
 */
public class Pilha_Auxiliar extends Pilha implements Serializable {

   public boolean colocarCarta(Pilha pilha, int id){
       if(id != 5 || id!= 6 || id != 7 || id !=8){
           Cartao c = pilha.pop();
           this.push(c);
           System.out.println(this);
           return true;
       }
       return false;
   }

   public boolean colocarCarta(Pilha pilha, int id , int numcarta){
       numcarta = numcarta - 1 ;
       if(id != 5 || id!= 6 || id != 7 || id !=8){
           Cartao c = pilha.get(numcarta);
           this.push(c);
           System.out.println(this);
           return true;
       }
       return false;
   }



}
