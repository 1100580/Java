/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex6;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago
 */
public class Main {
    public static double esfera(double r){
        return(4/3*(Math.PI)*(Math.pow(r,3)));
    }

    public static double cilindro(double a,double r){
        return((Math.PI)*(Math.pow(r,2))*a);
    }

    public static double cone(double a,double r){
        return(((1/(double)3)*(Math.PI))*(Math.pow(r,2))*(a));
    }
    
    public static void main(String[] args) {
           String sol="";
            do {
               sol=JOptionPane.showInputDialog("Introduza o tipo de sólido: esfera, cilindro ou cone");
               if(sol.equals("esfera")){
                    String vaux=JOptionPane.showInputDialog("Introduza o raio da esfera");
                    double raio=Double.parseDouble(vaux);
                    JOptionPane.showMessageDialog(null,"O volume da esfera é: "+esfera(raio));
               }
               if(sol.equals("cilindro")){
                    String vaux=JOptionPane.showInputDialog("Introduza o raio do cilindro");
                    double raio=Double.parseDouble(vaux);
                    String vaux2=JOptionPane.showInputDialog("Introduza a altura do cilindro");
                    double altura=Double.parseDouble(vaux2);
                    JOptionPane.showMessageDialog(null,"O volume do clindro é: "+cilindro(altura,raio));
               }
               if(sol.equals("cone")){
                    String vaux=JOptionPane.showInputDialog("Introduza o raio do cone");
                    double raio2=Double.parseDouble(vaux);
                    String vaux2=JOptionPane.showInputDialog("Introduza a altura do cone");
                    double altura2=Double.parseDouble(vaux2);
                    JOptionPane.showMessageDialog(null,"O volume do cone é: "+cone(altura2,raio2));
               }
           }
           while(!(sol.equals("FIM")));
   }

}

