package ficheiros1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ficheiros1 {

    public static void main(String[] args) throws FileNotFoundException {
        String[][] labin = new String[20][20];
        lerLabFich(labin);
        trocaB(labin);
        escreveLabin(labin);
    }

    private static void lerLabFich(String[][] labin) throws FileNotFoundException {
        Scanner in = new Scanner(new File("LAB.IN"));
        String s;
        String array [];
        int linha = 0;
        while (in.hasNext()) {
            s = in.nextLine();
            array = s.split("");
            int num = 1;
            int let = 2;
            int ind = 0;
            while (let <= array.length - 1) {
                int n = Integer.parseInt(array[num]);
                for (int i = 0; i < n; i++) {
                    labin[linha][ind++] = array[let];
                }
                let = let+2;
                num = num+2;
            }
            
            linha++;
        }
        //Fecha o Ficheiro
        if (in != null) {
            in.close();
        }
    }

    private static void escreveLabin(String[][] labin) throws FileNotFoundException {
        Formatter out = new Formatter(new File("LAB.OUT"));
        for (int i = 0; i < labin.length; i++) {
            for (int j = 0; j < labin[0].length; j++) {
                if (labin[i][j] != null) {
                    out.format("%s", labin[i][j]);
                }
            }
            out.format("%n");
        }
        if (out != null) {
            out.close();
        }       
    }

    private static void trocaB(String[][] labin) {
        for (int i = 0; i < labin.length; i++) {
            for (int j = 0; j < labin[0].length; j++) {
                if ("b".equals(labin[i][j])) {
                    labin[i][j] = " ";
                }
            }
        }
    }
}