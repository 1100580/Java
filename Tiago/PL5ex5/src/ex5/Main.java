/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex5;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago
 */
public class Main {
public static void disciplina(String nome, int pos, int neg){
    String s= "Disciplina:";
    String p= "";
    for (int i=1;i<=pos;i++){
          p=p+String.format("*");
    }
    s=s+String.format(" %s%n- Positivas: %s",nome,p);
    String n= "";
    for (int i=1;i<=neg;i++){
          n=n+String.format("*");
    }
    p=String.format("%n- Negativas: %s",n);
    s=s+p;
    System.out.println (s);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      disciplina("Matematica",5,5);
      disciplina("Portugues",10,5);
    }

}
