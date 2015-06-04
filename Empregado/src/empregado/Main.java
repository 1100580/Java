/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package empregado;

/**
 *
 * @author Lobito
 */
public class Main {

    public static void main(String[] args){

        Data d1 = new Data(2005, 1, 1);
        Tempo te1 = new Tempo(15, 00, 00);
        Tempo ts1 = new Tempo(19, 00, 00);
        Empregado e1 = new Empregado("Pedro", "Bessa", d1, te1, ts1);

        Data d2 = new Data(2005, 1, 2);
        Tempo te2 = new Tempo(15, 00, 00);
        Tempo ts2 = new Tempo(19, 00, 00);
        Empregado e2 = new Empregado("Pedro", "Bessa", d2, te2, ts2);

        Data d3 = new Data(2005, 1, 3);
        Tempo te3 = new Tempo(15, 00, 00);
        Tempo ts3 = new Tempo(19, 00, 00);
        Empregado e3 = new Empregado("Pedro", "Bessa", d3, te3, ts3);

        Data d4 = new Data(2005, 1, 4);
        Tempo te4 = new Tempo(15, 00, 00);
        Tempo ts4 = new Tempo(19, 00, 00);
        Empregado e4 = new Empregado("Pedro", "Bessa", d4, te4, ts4);

        Data d5 = new Data(2005, 1, 5);
        Tempo te5 = new Tempo(15, 00, 00);
        Tempo ts5 = new Tempo(19, 00, 00);
        Empregado e5 = new Empregado("Pedro", "Bessa", d5, te5, ts5);

        System.out.println(e1.lerDados());
        System.out.println(e1.imprimirToString());
        System.out.println("Esta semana fez " + e1.setHorasSemana(te1, ts1, te2, ts2, te3, ts3, te4, ts4, te5, ts5));
        System.out.println("Está contratado há "  + e1.setDiasContrato(d5) + " dias");
    }
}
