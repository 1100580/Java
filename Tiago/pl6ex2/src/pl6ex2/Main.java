/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6ex2;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author i090674
 */
public class Main {

    public static int Lerfuncionarios(String [] n, double [] v){
        String nome;
        int c;
        nome=JOptionPane.showInputDialog("introduza nome");
        c=0;
        while (!nome.equalsIgnoreCase("tt")){
            n[c]=nome;
            v[c]=Double.parseDouble(JOptionPane.showInputDialog("introduza vencimento"));
            c++;
            nome=JOptionPane.showInputDialog("introduza nome");
        }
        return(c+1);
    }


    public static void media(String [] n, double [] v){
        int i,c=0;
        double soma=0, media;
        for (i=0;i<n.length;i++){
            soma=soma+v[i];
            c++;
        }
        media=soma/c;
        for (i=0;i<v.length;i++){
            if(v[i]<media)
                System.out.println(n[i]);
        }
    }


    public static void percent(String [] n, double [] v){
        int ci=0, cont=0;
        double percent;
        double valor=Double.parseDouble(JOptionPane.showInputDialog("Valor:"));
        for (int i=0;i<v.length;i++){
            cont++;
            if(v[i]<valor)
                ci++;
        }
        percent=(ci/cont)*100;
        System.out.println("A percentagem de funcionários com vencimentos inferiores a "+valor+"é:"+percent+"%");
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] n = new String[50];
        double [] v = new double[50];
        Scanner ler = new Scanner(System.in);
        int numfunc;
        numfunc=Lerfuncionarios(n,v);
        System.out.println(numfunc);
        media(n,v);

    }

}
