package lernumero;

import java.io.*;

public class Leitura {

    public static String lerString(String msg) throws IOException {
        System.out.println(msg);
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        String s = d.readLine();
        //System.out.println(s);
        return s;
    }

    public static int lerInteiro(String msg) {
        int j = 0;
        int x = 0;
        while (j == 0) {
            try {
                x = Integer.parseInt(lerString(msg));
                j = 1;
            } catch (Exception e) {
                System.out.println("ERRO!!");
            }
        }
        return x;
    }

    public static float lerFloat(String msg) throws IOException {
        float x = Float.valueOf(lerString(msg)).floatValue();
        return x;
    }

    public static double lerDouble(String msg) throws IOException {
        double x = Double.valueOf(lerString(msg)).doubleValue();
        return x;
    }

    public static char lerCaracter(String msg) throws IOException {
        return (lerString(msg)).charAt(0);
    }
}
