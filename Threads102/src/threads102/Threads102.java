package threads102;

import java.util.ArrayList;
import java.util.Random;

public class Threads102 {

    static public int[] ListaIn = new int[1200];
    static public int[] ListaFin = new int[1200];
    static public boolean done1, done2;

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 1200; i++) {
            ListaIn[i] = r.nextInt(100);
        }
        System.out.println("Done Filling In");

        ClassT c1 = new ClassT(0);
        ClassT c2 = new ClassT(1);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

        while (done1 == false || done2 == false) {
        }

        for (int i = 800; i < 1200; i++) {
            ListaFin[i] = ListaIn[i] * 4 + 20;
        }

        for (int i = 0; i < 1200; i++) {
            System.out.println(ListaFin[i]);
        }
    }
}
