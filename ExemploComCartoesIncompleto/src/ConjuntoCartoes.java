import java.util.ArrayList;
import java.util.Collections;

public class ConjuntoCartoes extends ArrayList <Cartao> {
    
    public ConjuntoCartoes() {
        for (Cartao.Cor cor : Cartao.Cor.values())
            for (Cartao.Numero num : Cartao.Numero.values()) {
                this.add(new Cartao(num, cor));
            }
    }

    /** Baralhar os cartoes  */
    public void baralhar() {
        /** Uso do metodo java.util.Collections  */
        Collections.shuffle(this);
    }

    /** Partir o conjunto de cartoes  */
    public void partir() {
        /** Guarda primeira metade */
        ArrayList <Cartao> parte =  new ArrayList <Cartao>(this.subList(0,this.size()/2));
        /** Remove primeira metade */
        this.removeAll(parte);
        /** Coloca no final a primeira metade */
        this.addAll(parte);
    }
    
    /** Retira e devolve os primeiros n cartoes do Conjunto */
    public ArrayList <Cartao> primeirosCartoes(int n) {
        /** Guarda os n primeiros */
        ArrayList <Cartao> parte = new ArrayList <Cartao>(
                this.subList(0, ( n < this.size() ? n : this.size() ) ) );
        /** Remove os n primeiros */
        this.removeAll(parte);
        return parte;
    }

    /** Retira e devolve os ultimos n cartoes do Conjunto */
    public ArrayList <Cartao> ultimosCartoes(int n) {
        /** Guarda os n ultimos */
        ArrayList <Cartao> parte = new ArrayList <Cartao>(
          this.subList( (n > this.size() ? 0 : this.size()-n ), this.size() ) );
        /** Remove os n ultimos */
        this.removeAll(parte);
        return parte;
    }

    public int contaPontos() {
        int pontos = 0;
        for (Cartao c : this) pontos += c.getValor();
        return pontos;
    }

    /** Converte um conjunto de cartoes numa string (um cartao por linha)  */
    public String toString() {
        String s = "";
        for (Cartao c : this) {
            s = s + c.toString() + '\n';
        }
        return s;
    }   
}