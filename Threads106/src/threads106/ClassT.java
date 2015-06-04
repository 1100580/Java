package threads106;

import java.util.Random;

public class ClassT implements Runnable {

    static boolean first = true;
    static Object asomar; // Objecto de sincronização
    static int max = 0;
    private int trans = 0, pos, i;

    public ClassT(int i, int trans) {
        this.trans = trans;
        this.i = i;
    }

    ClassT(int trans, int pos, int checker) {
        this.trans = trans;
        this.pos = pos;
    }

    @Override
    public void run() {
        synchronized (ClassT.class) {
            if (first == true) { //A primeira thread define o barbeiro
                first = false;
                asomar = new Object();
            }
        }
        checkTrans();
    }

    private void checkTrans() {
        if (this.trans != 0) {
            Threads106.cli[pos]+=trans;
        }else{
            somar();
        }
    }

    private void somar() {
        int min, max;
        min = 1000/5 * i;
        max = 1000/5 * (i+1);
        for (int i = min; i < max; i++) {
            Threads106.soma+=Threads106.cli[i];
        }
    }
}
