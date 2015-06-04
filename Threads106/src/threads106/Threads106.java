package threads106;

import java.util.Random;

public class Threads106 {

    static public int soma = 0;
    static public int[]cli = new int[1000];

    public static void main(String[] args) {
        Random r = new Random();
        
        for (int i = 0; i < 1000; i++) {
            cli[i] = r.nextInt(100);
        }
        
        Object s = new Object();
        
        ClassT f1 = new ClassT(0,0);
        ClassT f2 = new ClassT(1,0);
        ClassT f3 = new ClassT(2,0);
        ClassT f4 = new ClassT(3,0);
        ClassT f5 = new ClassT(4,0);

        ClassT f6 = new ClassT(1, 16, -1);

        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);
        Thread t4 = new Thread(f4);
        Thread t5 = new Thread(f5);

        Thread t6 = new Thread(f6);

        synchronized (s) {
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
        }
        t6.start();
        
        System.out.println("Soma: " + soma);
    }
}
