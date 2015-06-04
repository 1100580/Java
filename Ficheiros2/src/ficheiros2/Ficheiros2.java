package ficheiros2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ficheiros2 {

    public static void main(String[] args) throws FileNotFoundException {
        String[][] maos = lerMaosFich();
        imprimeMat(maos);
        escreveOrdenadas(maos);
    }

    private static String[][] lerMaosFich() throws FileNotFoundException {
        Scanner fin = new Scanner(new File("maos.txt"));
        String[][] tempM = new String[10][2];
        String s;
        for (int i = 0; i < 10; i++) {
            s = fin.nextLine();
            tempM[i][0] = s.substring(0,2);
            tempM[i][1] = s.substring(3,5);
        }
        if (fin != null) {
            fin.close();
        }
        return tempM;
    }

    private static void imprimeMat(String[][] maos) {
        for (int i = 0; i < maos.length; i++) {
            for (int j = 0; j < maos[0].length; j++) {
                System.out.print(maos[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    private static void escreveOrdenadas(String[][] maos) throws FileNotFoundException {
        Formatter fout = new Formatter(new File("ordenadas.txt"));
        String ordenada[][] = new String[10][2];
        String altas[][] = new String[10][2];
        
        for (int i = 0; i < 10; i++) {
            if (maos[i][0].charAt(0) == 'A') {
                
            }else if(){
                
            }else if(){
        }
    }
}
