/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex3;
import javax.swing.JOptionPane;
/**
 *
 * @author i090674
 */
public class Main {
public static void tabuada(int num) {
    int i, r;
    String s ="";
    for (i=1;i<=10;i++){
        r=num*i;
        s=s+String.format("%2d x%2d=%d%n",num,i,i*num);
    }
 System.out.println (s);    
}
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int num;
        do{
       num=Integer.parseInt(JOptionPane.showInputDialog("Introduza o numero"));
       tabuada(num);
       }
        while(num!=0);
    }
}