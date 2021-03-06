package acessoAleatorio;

import java.util.ArrayList;
import java.io.*;

public class Exemplo2 {
    
    private static String fich = "C:\\banco_aleatorio.dat";
    
    public static void main(String[] args) throws IOException {
        //escrita no ficheiro
        ArrayList <Conta> contas = new ArrayList <Conta> ();
        contas.add( new Conta(1, "Joao", 500.00, new Data(2003,1,1)) );
        contas.add( new Conta(2, "Ana", 275.50, new Data(2004,10,31)) );
        contas.add( new Conta(3, "Rui", 3750.33, new Data(2004,11,11)) );
        
        DataOutputStream out = new DataOutputStream(new FileOutputStream(fich));
        for (Conta c : contas)
            c.writeConta(out);
        out.close();
        System.out.println("Escrita concluida...");
        
        //leitura do ficheiro
        ArrayList <Conta> contas2 = new ArrayList <Conta> ();
        
        DataInputStream in = new DataInputStream(new FileInputStream(fich));
        while( in.available() > 0 )
            contas2.add( Conta.readConta(in) );
        in.close();
        System.out.println("Leitura concluida...");
        
        for (Conta c : contas2)
            System.out.println( c.toString() );        
        
        
        //acrescentar uma nova conta
        Conta novaConta = new Conta(4, "Paulo", 2300.00, new Data(2004,11,12));
        RandomAccessFile frw = new RandomAccessFile(fich,"rw");
        frw.seek(frw.length());
        novaConta.writeConta(frw);
        frw.close();
        System.out.println("Conta acrescentada...");
        
        
        //nova leitura do ficheiro
        ArrayList <Conta> contas3 = new ArrayList <Conta> ();
        
        in = new DataInputStream(new FileInputStream(fich));
        while( in.available() > 0 )
            contas3.add( Conta.readConta(in) );
        in.close();
        System.out.println("Leitura concluida...");
        
        for (Conta c : contas3)
            System.out.println( c.toString() );
    }
    
}