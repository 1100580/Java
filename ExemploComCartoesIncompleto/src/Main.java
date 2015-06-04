import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        for (int x=0; x < 3; x++){
            ConjuntoCartoes conj = new ConjuntoCartoes();
            // Baralhar os cartoes
            conj.baralhar();
            // Retirar um conjunto de 5 cartoes
            SubConjuntoCartoes jogo = new SubConjuntoCartoes(conj.primeirosCartoes(5));
            System.out.println("Cartoes: " + jogo);
            
            // Quantas cores de cartoes ha´?
            ArrayList <Cartao.Cor> cores = jogo.coresDosCartoes();
            System.out.println("Neste subconjunto ha´ as cores: " + cores);
            
            // Quantas cartoes por cada cor?
            for (Cartao.Cor cor : cores)
                System.out.println("Neste jogo ha´ "+
                jogo.contarCartoesPorCor(cor) + " cartoes da cor " + cor);

            // Ordenar novamente o Jogo de fora da classe
            jogo.ordenar();
            System.out.println("Jogo ordenado: " + jogo);
            System.out.println();
        }
    }
}