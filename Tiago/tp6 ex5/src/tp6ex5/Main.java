/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tp6ex5;
import java.util.Scanner;
/**
 *
 * @author Tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler=new Scanner(System.in);
        System.out.println("Introduza o numero:");
        int num=ler.nextInt();
        int []v=new int [1000000];
        v[0]=num;
        int i=1;
        int tent=0;
        while (i<v.length){
            if(num%2==0){
                num=num/2;
                v[i]=num;
                tent++;
            }
            else{
                num=num+11;
                v[i]=num;
                tent++;
            }
            for(int j=i-1;j>=0;j--){
                if(v[i]==v[j]){
                    i=v.length;
                    break;
                }
            }
            i++;
        }
        System.out.println("Numero de tentativas: "+tent);
    }

}
