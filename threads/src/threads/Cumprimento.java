package threads;

public class Cumprimento extends Thread {

    private String mensagem;
    private int tempoEspera;
    private int numVezes;

    public Cumprimento(String m, int t, int n) {
        mensagem = m;
        tempoEspera = t;
        numVezes = n;
    }

    public void run() {
        try {
            for (int i = 0; i < numVezes; i++) {
                System.out.println(mensagem);
                sleep(tempoEspera);
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Cumprimento threadOla = new Cumprimento("Olá!", 20, 10);
        threadOla.start();

        Cumprimento threadAdeus = new Cumprimento("Adeus...", 100, 5);
        threadAdeus.start();
    }
}
