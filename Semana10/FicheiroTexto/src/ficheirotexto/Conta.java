package ficheirotexto;

import java.io.*;
import java.util.StringTokenizer;

public class Conta {
    
    private int num;
    private String nome;
    private double saldo;
    private Data abertura;
    
    public Conta(int num1, String n, double s, Data a) {
        num = num1;
        nome = n;
        saldo = s;
        abertura = a;
    }
    
    public void writeConta(BufferedWriter out) throws IOException {
        out.write("Cliente n.\t" + num); out.newLine();
        out.write("   Nome   :\t" + nome); out.newLine();
        out.write("   Saldo  :\t" + saldo); out.newLine();
        out.write("conta aberta em\t");
        abertura.writeData(out); out.newLine();
        out.write("--------------------------"); out.newLine();
    }

    public static Conta readConta(BufferedReader in) throws IOException {        
        StringTokenizer s;
        
        s = new StringTokenizer ( in.readLine(), "\t" );
        s.nextToken();
        int num1 = Integer.parseInt( s.nextToken() );

        s = new StringTokenizer ( in.readLine(), "\t" );
        s.nextToken();
        String nome1 = s.nextToken();

        s = new StringTokenizer ( in.readLine(), "\t" );
        s.nextToken();
        double saldo1 = Double.parseDouble( s.nextToken() );

        return new Conta(num1, nome1, saldo1, Data.readData(in));
    }
    
    public String toString() {
        return "Cliente n. " + num + ": " + nome + " tem um saldo de " + saldo +
               " euros (conta aberta em " + abertura.toString() + ").";
    }
    
}
