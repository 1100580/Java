package pkg1091391_1100580;

import java.util.*;

public class Main {
    static double mediaFinal,percAprovacao;
    public static void main(String[] args) {
        Thread t[]=new Thread[3];
        for(int i=0;i<3;i++){
            if(i==0)
                t[i]=new Thread(new Analisa(0));
            else
                t[i]=new Thread(new Analisa(1));
            t[i].start();
        }
        
        try{
            t[0].join();t[1].join();t[2].join(); //espera que threads manipuladoras de dados acabem
        }catch(InterruptedException e){}
        
        Thread t2=new Thread(new Analisa(2));
        t2.start();
        
        while(t2.isAlive()){}
        
        System.out.println("Notas finais (por aluno):");
        for(int i=0;i<300;i++){
            System.out.println(Analisa.vec[i].notaFinal);
        }
        
        System.out.println("Média dos alunos: "+ mediaFinal);
        System.out.println("Percentagem de alunos aprovados: "+percAprovacao+"%");
    }
}
