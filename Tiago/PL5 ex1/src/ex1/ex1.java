/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;
import javax.swing.JOptionPane;
/**
 *
 * @author i091081
 */
public class Main {
    public static boolean metodo1(String pal){
        boolean resp =true;
        pal=pal.toLowerCase();
        for (int i=0; i<pal.length()/2;i++){
            if(pal.charAt(i)!= pal.charAt(pal.length()-1-i)){
                resp=false; break;
            }
        }
        return resp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String pal;
        String vAuxiliar;
        int cont=0;
        
        vAuxiliar=JOptionPane.showInputDialog("Qual a palavra?");
        pal=vAuxiliar;
        while(!metodo1(pal)){
            cont++;
            vAuxiliar=JOptionPane.showInputDialog("Qual a palavra?");
            pal=vAuxiliar;
        }
        JOptionPane.showMessageDialog(null,"O número de palavras anteriroes ao palíndromo é="+cont);
    }

}
