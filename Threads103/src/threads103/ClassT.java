package threads103;

import java.util.Random;

public class ClassT implements Runnable {
    private int i, n;

    public ClassT(int ind, int num) {
        i = ind;
        n = num;
    }

    @Override
    public void run() {
        int ini, fim;
        ini = 1000 / 5 * i;
        fim = 1000 / 5 * (i + 1);
        for (int j = ini; j < fim; j++) {
            if (Threads103.vec[j] == n) {
                Threads103.e[i]=i;
                break;
            }
        }
    }
}
