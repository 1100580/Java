/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentoscomparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author i090674
 */
public class TesteVencimentosComparable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Patrao p = new Patrao("Jorge Silva", 800);
//        TrabCom tc = new TrabCom("Susana Ferreira", 400, 1500, (float) 0.06);
//        TrabHora th = new TrabHora("Carlos Miguel", 160, (float) 3.50);
//        Trabalhador vec[] = new Trabalhador[3];
//        vec[0] = p;
//        vec[1] = tc;
//        vec[2] = th;
//        for (int i = 0; i < vec.length; i++) {
//            System.out.println(vec[i].toString()+". Vencimento de: "+vec[i].vencimento()+"€");
//
//        }
//        for (int i = 0; i < vec.length; i++) {
//            if (vec[i] instanceof TrabCom) {
//                System.out.println(vec[i].toString());
//            }
//
//        }
        ArrayList trabs = new ArrayList();
        trabs.add(new Patrao("Jorge Silva", 800));
        trabs.add(new TrabCom("Susana Ferreira", 400, 1500, (float) 0.06));
        trabs.add(new TrabHora("Carlos Miguel", 160, (float) 3.50));
        Collections.sort(trabs);
        for (int i = 0; i < trabs.size(); i++) {
            Trabalhador t = (Trabalhador) trabs.get(i);
                System.out.println(t.toString() + t.vencimento());
            }
    }
}
