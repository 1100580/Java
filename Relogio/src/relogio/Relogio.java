package relogio;

public class Relogio extends Thread {

    private int segundos;
    private int minutos;

    public Relogio(int n) {
        segundos = 0;
    }

    public void run() {
        try {
            for (;checker;) {
                if (segundos <= 59) {
                    segundos++;
                } else {
                    segundos = 0;
                    minutos++;
                }
                sleep(1000);
            }
        } catch (Exception timer) {
        }
    }

    public static void main(String[] args) {
        Relogio tempo = new Relogio(10);
        tempo.start();
    }
}
