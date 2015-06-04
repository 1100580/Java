/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl4ex9;
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
       int n=0, a, b, soma;
      
           for(a=5;a<9999;a++){
                soma=0;
                for(b=a;b>1;b--){
                   if(a%(b-1)==0)
                      soma=soma+(b-1);
                }
                if(soma==a){
                   n=n+1;
                   JOptionPane.showMessageDialog(null,""+a);
                }
                if(n==4)
                    a=99999;
           }
       }
    }
