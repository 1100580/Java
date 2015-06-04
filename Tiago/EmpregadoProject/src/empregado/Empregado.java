/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package empregado;

import javax.swing.JOptionPane;
import utilitarios.*;

/**
 *
 * @author i090674
 */
public class Empregado {

    private String primNome;
    private String ultNome;
    private Data dataContracto;
    private Tempo horaEntrada;
    private Tempo horaSaida;

    public Empregado(String pn, String un, Data dc, Tempo he, Tempo hs) {
        primNome = pn;
        ultNome = un;
        dataContracto = dc;
        horaEntrada = he;
        horaSaida = hs;
    }

    public static Empregado lerEmpregado() {
        String pn = JOptionPane.showInputDialog("Primeiro nome:");
        String un = JOptionPane.showInputDialog("Último nome:");
        Data dc = Data.lerData();
        Tempo he = Tempo.lerTempo();
        Tempo hs = Tempo.lerTempo();
        return new Empregado(pn, un, dc, he, hs);
    }

    public String toString() {
        String s = "O empregado chama-se " + primNome + " " + ultNome + ". Assinou contracto em " + dataContracto.toAnoMesDiaString() + ". Entra às " + horaEntrada.toString() + " e sai às " + horaSaida.toString();
        return s;

    }

    public int horasSemanais(){
        int sec= horaEntrada.diferencaEmSegundos(horaSaida);
        int horas = sec/3600*5;
        return horas;
    }

    public int antiguidade(){
        Data hoje = new Data(2010,3,12);
        int tempo = dataContracto.diferenca(hoje)/360;
        return tempo;
    }
}
