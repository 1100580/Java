package empregado;

import javax.swing.JOptionPane;

public class Tempo {
    private int hora, minuto, segundo;

    public Tempo(){
        setHora(0);
        setMinuto(0);
        setSegundo(0);
    }

    public Tempo(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public String toString(){
        return ((hora < 9)? "0" + hora : "" + hora) +
               ((minuto < 9) ? ":0" + minuto : ":" + minuto) +
               ((segundo < 9) ? ":0" + segundo : ":" + segundo);
    }

    public void acrescentaSegundo() {
        segundo++;
        if (segundo == 60) {
            minuto ++;
            segundo = 0;
        }
        if (minuto == 60) {
            hora ++;
            minuto = 0;
        }
        if (hora == 24)
            hora = 0;
    }

    public int diferencaSegundos(Tempo tempo) {
        int tempo1Segs = hora * 3600 + minuto * 60 + segundo;
        int tempo2Segs = tempo.getHora() * 3600 + tempo.getMinuto() * 60 + tempo.getSegundo();
        return Math.abs(tempo1Segs - tempo2Segs);
    }

    public Tempo diferencaTempo(Tempo tempo) {
        int difSegs =  diferencaSegundos(tempo);
        int segundos = difSegs % 60;
        difSegs /= 60;
        int minutos = difSegs % 60;
        int horas = difSegs / 60;
        return new Tempo(horas, minutos, segundos);
    }

    public boolean tempoMaior(Tempo tempo){
        if (hora > tempo.getHora())
            return true;
        else if (hora == tempo.getHora() && minuto > tempo.getMinuto())
            return true;
        else if (hora == tempo.getHora() && minuto == tempo.getMinuto() && segundo > tempo.getSegundo())
            return true;
        return false;
    }

    public String somarCincoTempos(Tempo t1, Tempo t2, Tempo t3, Tempo t4, Tempo t5){
        int segundost1 = t1.getHora() * 3600 + t1.getMinuto() * 60 + t1.getSegundo();
        int segundost2 = t1.getHora() * 3600 + t1.getMinuto() * 60 + t1.getSegundo();
        int segundost3 = t1.getHora() * 3600 + t1.getMinuto() * 60 + t1.getSegundo();
        int segundost4 = t1.getHora() * 3600 + t1.getMinuto() * 60 + t1.getSegundo();
        int segundost5 = t1.getHora() * 3600 + t1.getMinuto() * 60 + t1.getSegundo();
        int total = segundost1 + segundost2 + segundost3 + segundost4 + segundost5;

        int horas = total/3600;
        total = total%3600;
        int minutos = total/60;
        int segundos = total%60;
        return String.format(horas + " horas, " + minutos + " minutos e " + segundos + " segundos de trabalho.");
    }

    public String tempoAMPM() {
        return ((hora < 9) ? "0" + hora : "" + hora) + ":" +
               ((minuto < 9) ? "0" + minuto : "" + minuto) + ":" +
               ((segundo < 9) ? "0" + segundo : "" + segundo) +
               ((hora < 12) ? " AM" : " PM");
    }

    public static Tempo lerTempo() {
        int hora = Integer.parseInt(JOptionPane.showInputDialog("Introduza a hora:"));
        int minuto = Integer.parseInt(JOptionPane.showInputDialog("Introduza o minuto:"));
        int segundo = Integer.parseInt(JOptionPane.showInputDialog("Introduza o segundo:"));
        return new Tempo(hora, minuto, segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = (hora < 0 || hora > 23) ? 0 : hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = (minuto < 0 || minuto > 59) ? 0 : minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = (segundo < 0 || segundo >59) ? 0 : segundo;
    }
}
