/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {
    public static void significativo(int []v){
        int nalg;
        int []vec = new int [5];
        for(int i=0;i<v.length;i++){
           if(v[i]>0){
               int num=v[i];
               nalg=0;
               while(num!=0){
                   vec[nalg]=num%10;
                   num=num/10;
                   nalg++;
               }
               for(int j=0;j<=(nalg-1/2);j++){
                   int aux=vec[j];
                   vec[j]=vec[(nalg-j)];
                   vec[(nalg-j)]=aux;
               }
               int maior=0;
               for(int k=0;k<vec.length;k++){
                   if(vec[k]>maior)
                       maior=vec[k];
               }
               for(int l=0;l<vec.length-1/2;l++){
                   if(vec[l]==maior){
                      System.out.println(v[i]);
                      break;
                   }
               }
           }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int []v = new int [5];
        int a=0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Introduda números entre 10 e 10000. (Para parar introduza 0 ou um número negativo)");
        for(int i=0;i<v.length;i++){
            a= ler.nextInt();
            if(a>0){
                if(a>=10 & a<=10000){
                   v[i]=a;
                }
                else{
                    System.out.println("Número invalido. Introduda números entre 10 e 10000.");
                    v[i]=ler.nextInt();
                }
            }
            else
                break;
        }
        System.out.println("Os números cujo maior dígito (ou um dos maiores digitos) é mais significativo do que no correspondente número invertido são:");
        significativo(v);
    }
}
