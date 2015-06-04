/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex3;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {

    public static int MDC(int a, int b){
        int resto;
        while(b != 0){
          resto = a % b;
          a = b;
          b = resto;
        }
        return(a);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);
        System.out.println("Introduza o número de números que pretende gerar:");
        int n=ler.nextInt();
        int []v = new int [n];
        for(int i=0;i<v.length;i++){
            v[i]=200+(int)(1801*Math.random());
        }
        System.out.println("Os máximos divisores comuns entre o primeiro e o último número, o segundo e o penúltimo, o terceiro e o antepenúltimo e assim sucessivamente são:");
        int i=0;
        int j=v.length-1;
        do{
            System.out.println(MDC(v[i],v[j]));
            i++;
            j--;
        }
        while(i<j);
    }
}

