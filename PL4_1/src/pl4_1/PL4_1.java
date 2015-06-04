package pl4_1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class PL4_1 {

    public static void main(String[] args) {
        /*
        int i = 0;
        double nota, soma = 0, media;
        String vAuxiliar;
        vAuxiliar = JOptionPane.showInputDialog("Qual a nota? (para terminar digite 0)");
        nota = Double.parseDouble(vAuxiliar);
        while (nota != 0) {
        soma = soma + nota;
        i++;
        vAuxiliar = JOptionPane.showInputDialog("Qual a nota? (para terminar digite 0)");
        nota = Double.parseDouble(vAuxiliar);
        }
        if (i > 0) {
        media = soma / i;
        JOptionPane.showMessageDialog(null, "A média das notas=" + media);
        } else {
        JOptionPane.showMessageDialog(null, "Não foram introduzidas notas");
        }
         */
        
        Scanner in = new Scanner(System.in);
        int n, c = 0, num = 1, soma;
        System.out.println("N?");
        n = in.nextInt();
        System.out.println("");
        do {
            soma = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    soma = soma + i;
                }
            }
            if (soma == num) {
                System.out.println(num);
                c++;
            }
            num++;
        } while (c < n);
    }
}