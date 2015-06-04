import java.util.LinkedList;
import java.util.Collections;

public class PilhaCartoes extends LinkedList <Cartao> {
    
    public PilhaCartoes() {
//        for (Cartao.Cor cor : Cartao.Cor.values())
            for (Cartao.Numero num : Cartao.Numero.values()) {
                this.addLast(new Cartao(num, Cartao.Cor.Azul));
            }
    }

    /** Baralhar os cartoes  */
    public void baralhar() {
        /** Uso do metodo java.util.Collections  */
        Collections.shuffle(this);
    }

    /** Partir o conjunto de cartoes  */
    public void partir() {
        /** primeira metade */
        int n = this.size()/2;
        for (int i = 0; i < n; i++) {
            this.addFirst(this.removeLast());
        }
    }
    
    /** Retira e devolve os primeiros n cartoes do Conjunto */
    public LinkedList <Cartao> primeirosCartoes(int n) {
        /** Cria um LinkedList vazio */
        if (n > this.size()) {
            n = this.size();
        } else{
            if (n > this.size()) {
                n = 0;
            }
        }
        LinkedList <Cartao> parte =  new LinkedList <Cartao>();
        for (int i = 0; i < n; i++) {
            parte.addLast(this.removeFirst());
        }
        return parte;
    }

    /** Retira e devolve os ultimos n cartoes do Conjunto */
    public LinkedList <Cartao> ultimosCartoes(int n) {
        /** Cria um LinkedList vazio */
        if (n > this.size()) {
            n = this.size();
        } else{
            if (n > this.size()) {
                n = 0;
            }
        }
        LinkedList <Cartao> parte =  new LinkedList <Cartao>();
        for (int i = 0; i < n; i++) {
            parte.addFirst(this.removeLast());
        }
        return parte;
    }
}