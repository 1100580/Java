package serializacao;

import java.io.*;

public class Conta implements Serializable {
    
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
        
    public void writeConta(ObjectOutputStream out) throws IOException {
        out.writeObject(this);
    }
    
    public static Conta readConta(ObjectInputStream in) throws IOException,
                                                        ClassNotFoundException {
        return (Conta) in.readObject();
    }
    
    public String toString() {
        return "Cliente n. " + num + ": " + nome + " tem um saldo de " + saldo +
               " euros (conta aberta em " + abertura.toString() + ").";
    }
    
}
