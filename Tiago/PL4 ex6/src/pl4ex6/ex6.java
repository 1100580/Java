/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl4ex6;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int a, b, aux, num, c, d, e=0;
    String vAuxiliar;

    vAuxiliar=JOptionPane.showInputDialog ("Qual o divisor?");
    a=Integer.parseInt(vAuxiliar);

    vAuxiliar=JOptionPane.showInputDialog ("Qual o dividendo?");
    b=Integer.parseInt(vAuxiliar);

    if(a>b){
        aux=a;
        a=b;
        b=aux;
    }

    vAuxiliar=JOptionPane.showInputDialog ("Número de números=");
    d=Integer.parseInt(vAuxiliar);

    for(c=1;c<=d;c++){
        do{
            vAuxiliar=JOptionPane.showInputDialog ("Qual o número?");
            num=Integer.parseInt(vAuxiliar);
        }
        while(num<0);
        if(num%a==0 & b%num==0)
        e++;
    }
    JOptionPane.showMessageDialog (null,"O número de números que são divisíveis pelo divisor e que dividem o dividendo é="+e);
    }

}
