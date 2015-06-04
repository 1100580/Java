package threads;

public class TesteSincronismo1 implements Runnable {
    private int contador;

    public void run() {
        for (int i = 0; i < 10000000; i++)
            incremento();
        System.out.println("Contador = " + contador);
    }

    public synchronized void incremento() {
        int i = contador;
        contador = i +1;
    }

    public static void main(String[] args) {
        TesteSincronismo1 c = new TesteSincronismo1();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
