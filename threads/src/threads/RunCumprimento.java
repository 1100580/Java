package threads;

public class RunCumprimento implements Runnable {
    private String mensagem;
    private int tempoEspera;
    private int numVezes;

    public RunCumprimento(String m, int t, int n) {
        mensagem = m;
        tempoEspera = t;
        numVezes = n;
    }

    public void run() {
        try {
            for( int i=0; i<numVezes; i++ ) {
                System.out.println(mensagem);
                Thread.sleep(tempoEspera);
            }
        }
        catch( InterruptedException e ) {
        }
    }

    public static void main(String[] args) {
        Runnable runOla = new RunCumprimento("Olá!",20,10);
        Thread threadOla = new Thread(runOla);
        threadOla.start();

        Runnable runAdeus = new RunCumprimento("Adeus...",100,5);
        Thread threadAdeus = new Thread(runAdeus);
        threadAdeus.start();
    }
}
