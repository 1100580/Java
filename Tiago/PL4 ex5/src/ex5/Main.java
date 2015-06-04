/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex5;
import javax.swing.JOptionPane;

/**
 *
 * @author i090674
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int num;
       int d;
       int aux=1;
       int res=0;

       String vAuxiliar;
       vAuxiliar=JOptionPane.showInputDialog("Número");
       num=Integer.parseInt(vAuxiliar);
       while(num!=0){
           d=num%10;
           if(d%2==1){
               res=res+d*aux;
               aux=aux*10;
           }
           num=num/10;
       }
       JOptionPane.showMessageDialog(null,"O resultado é:"+res);

    }

}
