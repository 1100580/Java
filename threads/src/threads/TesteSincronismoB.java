package threads;

public class TesteSincronismoB implements Runnable {
    private int contador;

    public void run() {
        for (int i = 0; i < 10000000; i++)
            incremento();
        System.out.println("Contador = " + contador);
    }

    public void incremento() {
        contador++;
    }

    public static void main(String[] args) {
        TesteSincronismoB c = new TesteSincronismoB();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}