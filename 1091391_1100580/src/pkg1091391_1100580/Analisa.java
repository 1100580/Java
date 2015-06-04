package pkg1091391_1100580;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Analisa implements Runnable {

    int trabalho;
    static Prova vec[];
    static int indiceVec;
    static Object synco, synco2;
    static boolean first = true, newAdd = false, acabou = false;

    public Analisa(int trab) {
        trabalho = trab;
    }

    public static Prova getProva() {
        Random generator = new Random();
        Prova p = new Prova();
        p.numeroAluno = generator.nextInt(999999);
        p.notaG1 = generator.nextInt(101);
        p.notaG2 = generator.nextInt(101);
        p.notaG3 = generator.nextInt(101);
        p.notaFinal = -1;
        return p;
    }

    @Override
    public void run() {
        synchronized (Analisa.class) {
            if (first) {
                first = false;
                synco = new Object();
                synco2 = new Object();
                indiceVec = 0;
                vec = new Prova[300];
            }
        }
        if (trabalho == 0) { //Preenche o vector   
            for (int i = 0; i < 300; i++) {
                vec[i] = getProva();
                synchronized (synco) {
                    newAdd = true;
                    synco.notifyAll();
                }
                while (newAdd) {
                }
            }
        } else if (trabalho == 1) { //Calcula a nota final
            while (!acabou) {
                synchronized (synco) {
                    while (!newAdd) {
                        try {
                            synco.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Analisa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    newAdd = false;
                    if (indiceVec >= 299) {
                        acabou = true;
                        synco.notifyAll();
                        newAdd = true;
                    }
                    if (indiceVec < 300) {
                        vec[indiceVec].notaFinal = (vec[indiceVec].notaG1 + vec[indiceVec].notaG2 + vec[indiceVec].notaG3) / 3;
                        indiceVec++;
                    }

                }
            }

        } else { //Determina a média
            int num = 0;
            for (int i = 0; i < 300; i++) {
                Main.mediaFinal += (double) vec[i].notaFinal;
                if (vec[i].notaFinal >= 50) {
                    num++;
                }
            }
            Main.mediaFinal /= 300;
            Main.percAprovacao = ((double)num / 300) * 100;
        }
    }
}
