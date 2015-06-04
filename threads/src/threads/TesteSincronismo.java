package threads;

public class TesteSincronismo implements Runnable {
    private int contador;

    public void run() {
        for (int i = 0; i < 10000000; i++)
            incremento();
        System.out.println("Contador = " + contador);
    }

    public void incremento() {
        int i = contador;
        contador = i +1;
    }

    public static void main(String[] args) {
        TesteSincronismo c = new TesteSincronismo();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}