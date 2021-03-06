package MotorDeJogo;

import java.io.Serializable;

public class Cartao implements Comparable<Cartao>, Serializable {

// Tipos enumerados de possiveis cartoes
    public static enum Numero {
        Um, Dois, Tres, Quatro, Cinco, Seis, Sete
    };

// Tipos enumerados de possiveis cores
    public static enum Cor {
        azul, vermelho, amarelo
    };

    private Numero num;
    private Cor cor;

    public Cartao(Numero num, Cor cor) {
        this.num = num;
        this.cor = cor;
    }

    /** Converte um cartao numa string. ex: "Tres Azul" */
    public String toString() {
        return cor.toString() + "_" + getValor();
    }

    /** Devolve o numero do cartao */
    public Numero getNumero() {
        return num;
    }

    /** Devolve a cor do cartao */
    public Cor getCor() {
        return cor;
    }

    /** Devolve o valor do cartao */
    public int getValor() {
        return num.ordinal() + 1;
    }

    public boolean equals(Object o) {
        Cartao c = (Cartao) o;
        return (num == c.num && cor == c.cor);
    }

    public int compareTo(Cartao o) {
        if (cor != o.cor) {
            return cor.compareTo(o.cor);
        }
        return num.compareTo(o.num);
    }

}
