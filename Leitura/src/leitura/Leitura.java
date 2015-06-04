package leitura;
import java.io.*;
import java.util.Scanner;

public class Leitura {
    public static String lerString(String msg) throws IOException {
        System.out.println(msg);
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    public static int lerInteiro(String msg) throws IOException {
        int x=Integer.parseInt( lerString(msg) );
        return x;
    }

    public static float lerFloat(String msg) throws IOException {
        float x=Float.valueOf( lerString(msg) ).floatValue();
        return x;
    }

    public static double lerDouble(String msg) throws IOException {
        double x=Double.valueOf( lerString(msg) ).doubleValue();
        return x;
    }

    public static char lerCaracter(String msg) throws IOException {
        return ( lerString(msg) ).charAt(0);
    }
}