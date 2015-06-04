package threads102;

import java.util.Random;

public class ClassT implements Runnable {
    private int i;

    public ClassT(int ind) {
        i = ind;
    }

    @Override
    public void run() {
        int ini, fim;
        ini = 1200 / 3 * i;
        fim = 1200 / 3 * (i + 1);
        for (int j = ini; j < fim; j++) {
            Threads102.ListaFin[j] = Threads102.ListaIn[j] * 4 + 20;
            if (fim == 400) {
                Threads102.done1 = true;
            }
            if (fim == 800) {
                Threads102.done2 = true;
            }
        }
    }
}
