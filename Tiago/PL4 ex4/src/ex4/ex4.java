/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex4;

import javax.swing.JOptionPane;

/**
 *
 * @author i090674
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String nome;
        int idade;
        int cont=0;
        int cont18=0;

        nome=JOptionPane.showInputDialog("Qual a o nome? (para terminar digite zzz)");
        while (!nome.equals("zzz"))
        {
            String vAuxiliar;
        vAuxiliar=JOptionPane.showInputDialog("Qual a Idade?");
        idade=Integer.parseInt(vAuxiliar);
        cont++;
        if(idade>=18);{
            cont18++;
            JOptionPane.showMessageDialog(null,""+nome);
        }
        nome=JOptionPane.showInputDialog("Qual a o nome? (para terminar digite zzz)");
        }
        JOptionPane.showMessageDialog(null,"A média de pessoas com idades maiores ou iguais a 18 anos é="+((cont18)/(cont)*100)+"%");
        }
}
