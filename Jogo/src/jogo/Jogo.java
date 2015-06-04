/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.io.Serializable;
import java.util.ArrayList;
import jogo.Cartao.Numero;

/**
 *
 * @author Gisela
 */
public class Jogo implements Serializable {

    ArrayList<Cartao> cartoes_do_jogo;
    //Pilhas Principais
    Numero[] seq1 = {Numero.Dois, Numero.Tres, Numero.Quatro, Numero.Cinco, Numero.Seis, Numero.Sete};
    Numero[] seq2 = {Numero.Quatro, Numero.Seis, Numero.Um, Numero.Tres, Numero.Cinco, Numero.Sete};
    Numero[] seq3 = {Numero.Seis, Numero.Dois, Numero.Cinco, Numero.Um, Numero.Quatro, Numero.Sete};
    Numero[] seq4 = {Numero.Um, Numero.Cinco, Numero.Dois, Numero.Seis, Numero.Tres, Numero.Sete};
    Pilha_Principal p_p1 = new Pilha_Principal(seq1);
    Pilha_Principal p_p2 = new Pilha_Principal(seq2);
    Pilha_Principal p_p3 = new Pilha_Principal(seq3);
    Pilha_Principal p_p4 = new Pilha_Principal(seq4);
    //Pilhas Auxiliares
    Pilha_Auxiliar p_aux1 = new Pilha_Auxiliar();
    Pilha_Auxiliar p_aux2 = new Pilha_Auxiliar();
    Pilha_Auxiliar p_aux3 = new Pilha_Auxiliar();
    Pilha_Auxiliar p_aux4 = new Pilha_Auxiliar();
    //Baralho
    Baralho baralho = new Baralho();

    public Jogo() {
        
        String cor;
      
        // pilha principal 1
        boolean encontrou1 = false;
        int i = 0;
        while (!encontrou1) {
            
            // percorrer as cartas até encontrar um 1
            if (baralho.get(i).getNumero() == Numero.Um) {
                encontrou1 = true;
                Cartao c = baralho.get(i);
                p_p1.add(c);
                baralho.remove(i);
            }
            i++;

        }
        //pilha principal 2
        boolean encontrou2 = false;
        i = 0;
        while (!encontrou2) {
            
            // percorrer as cartas até encontrar um 1
            if (baralho.get(i).getNumero() == Numero.Dois) {
                encontrou2 = true;
                Cartao c = baralho.get(i);
                p_p2.add(c);
                baralho.remove(i);
                
            }
            i++;

        }
        // pilha principal 3
        boolean encontrou3 = false;
        i = 0;
        while (!encontrou3) {
           
            // percorrer as cartas até encontrar um 1
            if (baralho.get(i).getNumero() == Numero.Tres) {
                encontrou3 = true;
                Cartao c = baralho.get(i);
                p_p3.add(c);
                baralho.remove(i);
                
            }
            i++;

        }
        // pilha principal 4
        boolean encontrou4 = false;
        i = 0;
        while (!encontrou4) {
            
            // percorrer as cartas até encontrar um 1
            if (baralho.get(i).getNumero() == Numero.Quatro) {
                encontrou4 = true;
                Cartao c = baralho.get(i);
               
                p_p4.add(c);
                baralho.remove(i);
            }
            i++;

        }
       

    }

    public boolean colocarCarta(int pilhaDeOrigem, int pilhaDeDestino, int cartao_actual_baralho) {
        Pilha p = getPilha(pilhaDeOrigem);

        switch (pilhaDeOrigem)
        {
            case (9):
                // carta vem do baralho
                // tenho de enviar o index da carta actual do baralho e nao utilizar o peekfirst
                switch (pilhaDeDestino) {
                case 1:
                if (p_p1.colocarCarta(p,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 2:
                if (p_p2.colocarCarta(p,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 3:
                if (p_p3.colocarCarta(p,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 4:
                if (p_p4.colocarCarta(p,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 5:
               
                if (p_aux1.colocarCarta(p, pilhaDeOrigem,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 6:
                if (p_aux2.colocarCarta(p, pilhaDeOrigem,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 7:
                if (p_aux3.colocarCarta(p, pilhaDeOrigem,cartao_actual_baralho)) {
                    return true;
                }
                break;
            case 8:
                if (p_aux4.colocarCarta(p, pilhaDeOrigem,cartao_actual_baralho)) {
                    return true;
                }
                break;
            }
            default:
               


        switch (pilhaDeDestino) {
            case 1:
                
                if (p_p1.colocarCarta(p)) {
                    return true;
                }
                break;
            case 2:
                if (p_p2.colocarCarta(p)) {
                    return true;
                }
                break;
            case 3:
                if (p_p3.colocarCarta(p)) {
                    return true;
                }
                break;
            case 4:
                if (p_p4.colocarCarta(p)) {
                    return true;
                }
                break;
            case 5:
                if (p_aux1.colocarCarta(p, pilhaDeOrigem)) {
                    return true;
                }
                break;
            case 6:
                if (p_aux2.colocarCarta(p, pilhaDeOrigem)) {
                    return true;
                }
                break;
            case 7:
                if (p_aux3.colocarCarta(p, pilhaDeOrigem)) {
                    return true;
                }
                break;
            case 8:
                if (p_aux4.colocarCarta(p, pilhaDeOrigem)) {
                    return true;
                }
                break;
        }
        }

        
   
return false;
    }


    public Pilha getPilha(int id) {
        switch (id) {
            case 1:
                return p_p1;
            case 2:
                return p_p2;
            case 3:
                return p_p3;
            case 4:
                return p_p4;
            case 5:
                return p_aux1;
            case 6:
                return p_aux2;
            case 7:
                return p_aux3;
            case 8:
                return p_aux4;
            case 9:
                return baralho;

        }
        {
            Default:
            return null;
        }

    }
}
