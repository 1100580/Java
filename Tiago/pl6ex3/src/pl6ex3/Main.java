/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6ex3;
import java.util.Scanner;
/**
 *
 * @author i090674
 */
public class Main {

   
    public static void inverter(int v[]){
        int num=(v.length-1);
        for(int i=0;i<(v.length/2); i++){
            int aux=v[i];
            v[i]=v[(num-i)];
            v[(num-i)]=aux;
        }
        System.out.println("Vector invertido:");
        for (int i=0;i<v.length;i++)
            System.out.println(v[i]);
    }
    
    public static void rotacao(int v[]){
        int aux=v[(v.length-1)];
        for (int i=(v.length-2);i>=0;i--){
            v[i+1]=v[i];
        }
        v[0]=aux;
        System.out.println("Vector rodado:");
        for (int i=0;i<v.length;i++)
            System.out.println(v[i]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        System.out.println("Introduza o numero de elementos do vector:");
        Scanner ler = new Scanner(System.in);
        int num=ler.nextInt();
        int[] v = new int[num];
        System.out.println("Introduza os elementos do vector:");
        for(i = 0; i < v.length; i++)
            v[i]=ler.nextInt();
        inverter(v);
        rotacao(v);

    }
}
