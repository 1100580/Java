public class Cartao implements Comparable<Cartao> {
    
    // Tipos enumerados de possiveis numeros para os cartoes
    public static enum Numero { Um, Dois, Tres, Quatro, Cinco, Seis, Sete };
    // Tipos enumerados de possiveis cores
    public static enum Cor { Azul, Vermelho, Amarelo, Verde };

    private Numero num;
    private Cor cor;
  
    public Cartao(Numero num, Cor cor) {
        this.num = num; this.cor = cor;
    }
  
    /** Converte um cartao numa string. Ex: "Tres Azul"  */
    public String toString() {
        return num.toString() + " " + cor.toString();
    }
    /** Devolve o numero do cartao  */
    public Numero getNumero() {
        return num;
    }
    /** Devolve a cor do cartao  */
    public Cor getCor() {
        return cor;
    }
    /** Devolve o valor do cartao  */
    public int getValor() {
        return 1 + num.ordinal();
    }
    public boolean equals(Object o) {
        Cartao c = (Cartao) o;
        return (num==c.num && cor==c.cor);
    }
    public int compareTo(Cartao o) {
        if (cor!=o.cor) return cor.compareTo(o.cor);
        return num.compareTo(o.num);
    }
}
