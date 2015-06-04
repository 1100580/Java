package threads105;

import java.util.Random;

public class ClassT implements Runnable {

    static boolean first = true;
    static Object synco, sentar; // Objecto de sincronização
    static int max = 0;
    int cli;
    private boolean barb = false;

    public ClassT(int cli) {
        this.cli = cli;
    }

    @Override
    public void run() {
        synchronized (ClassT.class) {
            if (first == true) { //A primeira thread define o barbeiro
                first = false;
                sentar = new Object();
                barb = true;
            }
        }
        if (barb) {
            while (true) {
                atendeCliente();
            }
        } else {
            entrar();
        }
    }

    private void entrar() {
        if (checklugares()) {
        } else {
            System.out.println("Todos os lugares cheios.");
        }
    }

    private boolean checklugares() {
        synchronized (sentar) {
            for (int i = 0; i < 3; i++) {
                if (Threads105.lugares[i] == -1) {
                    //senta
                    Threads105.lugares[i] = cli;
                    System.out.println("Senta no lugar " + i);
                    return true;
                }
            }
        }
        return false;
    }

    private void atendeCliente() {
        for (int i = 0; i < 3; i++) {
            if (Threads105.lugares[i] != -1) {
                System.out.println("Corta o cabelo ao cliente " + Threads105.lugares[i]);
                Threads105.lugares[i] = -1;
            }
        }
    }
}
