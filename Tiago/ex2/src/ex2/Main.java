/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex2;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {

    public static void media(int n){
       int nalg=0;
       int soma=0;
       while(n>0){
           soma=soma+n%10;
           n=n/10;
           nalg++;
       }
       double media=soma/nalg;
       System.out.println("A média dos algarismos é:"+media);
    }

    public static void diferenca(int num,int nalg){
        int []v= new int [nalg];
        for(int i=v.length-1;i>=0;i--){
            v[i]=num%10;
            num=num/10;
        }
        int maior=0;
        for(int i=0;i<v.length-1;i++){
            int dif=v[i]-v[i+1];
            if(dif>maior)
                maior=dif;
        }
        System.out.println("A maior diferença absoluta entre dois algarismos consecutivos é: "+maior);
    }

    public static void capicua(int num){
        int contpos=0;
        int contneg=0;
        boolean capicua=false;
        for(int i=0;i<9999;i++){
             contpos++;
             capicua=false;
             int inverso=0;
             int potencia=1;
             for(int cont=num+i;cont>=10;cont/=10){
                 potencia*=10;
                 inverso=(inverso+(cont%10))*10;
             }
             inverso+=(inverso/potencia);
             if(inverso==num+i){
                 capicua=true;
                 break;
             }
         }
         for(int i=0;i<9999;i++){
             contneg++;
             capicua=false;
             int inverso=0;
             int potencia=1;
             for(int cont=num-i;cont>=10;cont/=10){
                 potencia*=10;
                 inverso=(inverso+(cont%10))*10;
             }
             inverso+=(inverso/potencia);
             if(inverso==num-i){
                 capicua=true;
                 break;
             }
         }
        int cappos=num+contpos;
        int capneg=num-contneg;
        if(contneg>contpos){
            System.out.println("O número capicua mais próximo é o "+capneg);
        }
        else
            System.out.println("O número capicua mais próximo é o "+cappos);
    }

    public static void primos(int num){
        boolean primo=true;
        int numprim=0;
        for(int i=3;i<num;i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
                   primo=false;
                   break;
                }
            }
            if(primo=true)
                if(num%i==0)
                    numprim++;
        }
        if(num%2==0)
          numprim++;
        System.out.println("Número de divisores primos: "+numprim);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        do{
            System.out.println("Introduza o número");
            num=ler.nextInt();
        }
        while(num<9);
        int nalg=0;
        while(num>0){
           num=num/10;
           nalg++;
           }
        System.out.println("MENU:");
        System.out.println("1 - Média dos algarismos");
        System.out.println("2 - Maior diferença absoluta entre dois algarismos consecutivos");
        System.out.println("3 - Número capicua mais próximo");
        System.out.println("4 - Quantidade de divisores primos");
        System.out.println("Introduza a sua opção");
        int opcao=ler.nextInt();
        switch (opcao){
            case '1':
                media(num);
                break;
            case '2':
                diferenca(num,nalg);
                break;
            case '3':
                capicua(num);
                break;
            case '4':
                primos(num);
                break;
        }
    }

}
