package InterfaceGrafica;

public class Relogio extends Thread {

    private int minutos, segundos, sleepTime;
    private static int jogadas;

    public Relogio(int n) {
        sleepTime = n;
    }

    @Override
    public void run() {
        try {
            for (;;) {
                if (segundos <= 58) {
                    segundos++;
                } else {
                    segundos = 0;
                    minutos++;
                }
                MesaGUI.tempoLabel.setText("Tempo: " + getMinutos() + ":" + getSegundos() + " | Jogadas: " + getJogadas());
                sleep(sleepTime);
            }
        } catch (Exception timer) {
        }
    }

    public int getJogadas() {
        return jogadas;
    }
    public int getMinutos(){
        return minutos;
    }
    public int getSegundos(){
        return segundos;
    }

    public static void setjogadas(int jogadas) {
        Relogio.jogadas = jogadas;
    }
}
