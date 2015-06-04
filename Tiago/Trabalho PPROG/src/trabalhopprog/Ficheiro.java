/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Tiago
 */
public class Ficheiro {

    public static void LerFicheiro(String nomefich, ArrayPerguntas a) throws FileNotFoundException {
        File f = new File(nomefich);
        Scanner ler = new Scanner(f, "ISO-8859-1");
        while (ler.hasNext()) {
            String tema = ler.nextLine();
            int t = Integer.parseInt(ler.nextLine());
            String perg = ler.nextLine();
            switch (t) {
                case 1:
                    int nr1 = Integer.parseInt(ler.nextLine());
                    String[] r1 = new String[nr1];
                    for (int i = 0; i < r1.length; i++) {
                        r1[i] = ler.nextLine();
                    }
                    int rc1 = Integer.parseInt(ler.nextLine());
                    a.add(new RespostaUnica(perg, r1, rc1, tema));
                    break;
                case 2:
                    int nr2 = Integer.parseInt(ler.nextLine());
                    String[] r2 = new String[nr2];
                    for (int i = 0; i < r2.length; i++) {
                        r2[i] = ler.nextLine();
                    }
                    String[] src2 = ler.nextLine().split(",");
                    boolean[] rc2 = new boolean[src2.length];
                    for (int i = 0; i < rc2.length; i++) {
                        if (src2[i].equals("1")) {
                            rc2[i] = true;
                        } else {
                            rc2[i] = false;
                        }
                    }
                    a.add(new RespostaMultipla(perg, r2, rc2, tema));
                    break;
                case 3:
                    String[] rc3 = ler.nextLine().split(";");
                    a.add(new RespostaExtenso(perg, rc3, tema));
                    break;
            }
            ler.nextLine();
        }
        ler.close();
    }
}
