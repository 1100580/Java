/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author i090674
 */
public class ArrayPerguntas extends ArrayList<Pergunta> {

    public void baralhar() {
        Collections.shuffle(this);
    }

    public ArrayPerguntas escolherPerguntasTeste(String[] t, int[] q) {
        ArrayPerguntas a = new ArrayPerguntas();
        this.baralhar();
        boolean b = false;
        for (int i = 0; i < q.length; i++) {
            if (q[i] != 0) {
                b = true;
                break;
            }
        }
        if (b == true) {
            for (int i = 0; i < q.length; i++) {
                this.escolherPerguntasTema(t[i], q[i], a);
            }
        } else {
            int pergportema = 10 / q.length;
            if (q.length == 3) {
                this.escolherPerguntasTema(t[0], 4, a);
                this.escolherPerguntasTema(t[1], 3, a);
                this.escolherPerguntasTema(t[2], 3, a);
            } else if (q.length == 4) {
                this.escolherPerguntasTema(t[0], 2, a);
                this.escolherPerguntasTema(t[1], 3, a);
                this.escolherPerguntasTema(t[2], 3, a);
                this.escolherPerguntasTema(t[3], 2, a);
            } else {
                for (int i = 0; i < q.length; i++) {
                    this.escolherPerguntasTema(t[i], pergportema, a);
                }
            }
        }
        a.baralhar();
        return (a);
    }

    public void escolherPerguntasTema(String tema, int np, ArrayPerguntas a) {
        int i = 0;
        int n = 0;
        while (n < np) {
            if (this.get(i).getTopico().equals(tema)) {
                a.add(this.get(i));
                n++;
            }
            i++;
        }
    }
}

    