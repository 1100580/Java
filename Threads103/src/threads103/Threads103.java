package threads103;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Threads103 {

    static public int[] e = {-1, -1, -1, -1, -1};
    static public int[] vec = new int[1000];
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            vec[i] = i;
        }
        System.out.println("Done Filling In, insert num.");
        int num = ler.nextInt();
        
        ClassT c1 = new ClassT(0,num);
        ClassT c2 = new ClassT(1,num);
        ClassT c3 = new ClassT(2,num);
        ClassT c4 = new ClassT(3,num);
        ClassT c5 = new ClassT(4,num);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        Thread t5 = new Thread(c5);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        while (e[0] < 0 && e[1] < 0 && e[2] < 0 && e[3] < 0 && e[4] < 0) {
        }
        
        System.out.print("Numero encontrado nas threads: ");
        for (int i = 0; i < 5; i++) {
            if (e[i]>=0) {
                System.out.println(e[i]);
            }
        }
    }
}
