/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package batalhanaval;


public class Porbarcos {

    public static int[][] porbarcos(String[] args) {
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
