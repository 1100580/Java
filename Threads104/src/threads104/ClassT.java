package threads104;

import java.util.Random;

public class ClassT implements Runnable {

    static private int[] ListaIn = new int[Threads104.TAMLISTA + 1];
    static private int[] ListaFinal = new int[Threads104.TAMLISTA];
    static boolean first = true;
    static Object synco; // Objecto de sincronização
    static int max = 0;
    int fil;
    boolean locked = false;

    public ClassT(int fil) {
        this.fil = fil;
    }

    @Override
    public void run() {
        synchronized (ClassT.class) {
            if (first == true) { //A primeira thread lança vigia
                first = false;
                synco = new Object();
            }
        }
        comer();
    }

    private void comer() {
        int ant, pro;
        ant = fil;
        pro = fil + 1;
        if (pro > 4) {
            pro = 0;
        }
        synchronized (synco) {
            System.out.println("A pegar no pau " + ant);
            if (Threads104.paus[ant] == 1) {
                Threads104.paus[ant] = 0;
            } else {
                System.out.println("Pau ant ocupado.");
                locked = true;
            }
        }
        synchronized (synco) {
            System.out.println("A pegar no pau " + pro);
            if (Threads104.paus[pro] == 1) {
                Threads104.paus[pro] = 0;
            } else {
                System.out.println("Pau pro ocupado.");
                locked = true;
            }
        }
        if (!locked) {
            System.out.println("Comeu o filosofo " + fil);
        }
        //Release
        locked = false;
        Threads104.paus[ant] = 1;
        Threads104.paus[pro] = 1;
    }
}
