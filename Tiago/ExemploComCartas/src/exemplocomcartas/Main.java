/*
 * Main.java
 *
 * Created on 30 de Março de 2007, 15:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package exemplocomcartas;

import java.util.ArrayList;

/**
 *
 * @author Nuno Malheiro
 */
public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int x = 0; x < 1; x++) {
            // Baralhar as cartas
            Baralho b = new Baralho(Baralho.Tipo.BAR_40);
            b.baralhar();
            // Retirar um conjunto de 10 cartas
            MaoDeJogo jogo = new MaoDeJogo(b.primeirasCartas(10));
            System.out.println("Jogo: " + jogo);

            // Quantos tipos de cartas há?
            ArrayList<Carta.Tipo> at = jogo.tiposDeCarta();
            System.out.println("Neste jogo há os tipos: " + at);

            // Quantas cartas por cada tipo?
            for (Carta.Tipo t : at) {
                System.out.println("Neste jogo há " + jogo.contarCartasDoTipo(t) + " cartas do tipo " + t);
            }

            // Ordenar novamente o Jogo de fora da classe
            jogo.ordenar();
            System.out.println("Jogo ordenado: " + jogo);
        }
    }
}
