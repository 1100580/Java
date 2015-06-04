
package batalhanaval;

import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        int barco = 0;
        int cox, coy;
        int [][] campo = new int[7][7];
        campo = porbarcos();
        while (barco != 2){
            cox = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada x"));
            coy = Integer.parseInt(JOptionPane.showInputDialog("Insira a coordenada y"));
            if (campo[cox][coy] == 1) {
                System.out.println("Acertou");
                campo[cox][coy] = 2;
                if (campo[cox][coy] == 2 && campo[cox+1][coy] == 2 && campo[cox-1][coy] == 2) {
                    System.out.print(" e afundou");
                    barco += 1;
                }
            } else{
                System.out.println("Falhou");
            }
        }
        System.out.println("Ganhou.");
    }

    public static int[][] porbarcos() {
        int [][] campo = new int[7][7];
        int l1 = (int) (Math.random()*5 + 1);
	int a1 = (int) (Math.random()*5 + 1);
        int l2 = (int) (Math.random()*5 + 1);
	int a2 = (int) (Math.random()*5 + 1);
        int l3 = (int) (Math.random()*5 + 1);
	int a3 = (int) (Math.random()*5 + 1);
        double ranVal;
        boolean check = false;

            ranVal = (double) (Math.random());
                campo[l1][a1] = 1;
                if (ranVal >= 0.5) {
                    campo[l1+1][a1] = 1;
                    campo[l1-1][a1] = 1;
                } else{
                campo[l1][a1+1] = 1;
                campo[l1][a1-1] = 1;
                }

            ranVal = (double) (Math.random());
            while ((campo[l2][a2] == 1 || campo[l2+1][a2] == 1 || campo[l2-1][a2] == 1) || (campo[l2][a2] == 1 || campo[l2][a2+1] == 1 || campo[l2][a2-1] == 1)){
                l2 = (int) (Math.random()*5 + 1);
                a2 = (int) (Math.random()*5 + 1);
            }
                campo[l2][a2] = 1;
                if (ranVal >= 0.5) {
                    campo[l2+1][a2] = 1;
                    campo[l2-1][a2] = 1;
                } else{
                campo[l2][a2+1] = 1;
                campo[l2][a2-1] = 1;
                }

            ranVal = (double) (Math.random());
            while ((campo[l3][a3] == 1 || campo[l3+1][a3] == 1 || campo[l3-1][a3] == 1) || (campo[l3][a3] == 1 || campo[l3][a3+1] == 1 || campo[l3][a3-1] == 1)){
                l3 = (int) (Math.random()*5 + 1);
                a3 = (int) (Math.random()*5 + 1);
            }
                campo[l3][a3] = 1;
                if (ranVal >= 0.5) {
                    campo[l3+1][a3] = 1;
                    campo[l3-1][a3] = 1;
                } else{
                campo[l3][a3+1] = 1;
                campo[l3][a3-1] = 1;
                }

        for(int i = 0; i <= 6; i++) {
            System.out.print("[");
            for(int j = 0; j <= 6; j++) {
                System.out.print(" " + campo[i][j]);
            }
        System.out.println(" ]");
        }
        return campo;
    }
}