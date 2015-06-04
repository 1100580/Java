
package threads105;

public class Threads105 {

    static public int[] lugares = {-1,-1,-1};
        public static void main(String[] args) {
        ClassT f1 = new ClassT(0); //barbeiro
        ClassT f2 = new ClassT(1);
        ClassT f3 = new ClassT(2);
        ClassT f4 = new ClassT(3);
        ClassT f5 = new ClassT(4);
        
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);
        Thread t4 = new Thread(f4);
        Thread t5 = new Thread(f5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
