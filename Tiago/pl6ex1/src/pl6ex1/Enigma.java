/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6ex1;
import java.util.Scanner;
/**
 *
 * @author i090674
 */
public class Enigma {
      public static int maior(int []vec){

        int maior=vec[0];
        for(int i= 0; i < vec.length; i++){
            if (vec[i]>maior)
                maior=vec[i];
        }
        return(maior);
    }

    public static void main(String[] args) {
        int i, s=0, c=0;
        int[] v = new int[10];
        Scanner ler = new Scanner(System.in);
        for(i = 0; i < v.length; i++){
            System.out.println("numeros");
            v[i]=ler.nextInt();}
        for(i = 0; i < v.length; i++)
            if (i % 2 == 0){
                s = s + v[i];
                c++;
            }
        if(c!=0)
            System.out.println(s/c);
        System.out.println("Indices");
        int max=maior(v);
        for (i=0;i<v.length;i++){
            if(v[i]==max)
                System.out.println(i);
        }

    }
  



}

