package acessoSequencialBinario;

import java.io.*;

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
    
    public void writeConta(DataOutputStream out) throws IOException {
        out.writeInt(num);
        out.writeUTF(nome);
        out.writeDouble(saldo);
        abertura.writeData(out);
    }
    
    public static Conta readConta(DataInputStream in) throws IOException {
        return new Conta( in.readInt(),
                          in.readUTF(),
                          in.readDouble(),
                          Data.readData(in) );
    }
    
    public String toString() {
        return "Cliente n. " + num + ": " + nome + " tem um saldo de " + saldo +
               " euros (conta aberta em " + abertura.toString() + ").";
    }
    
}
