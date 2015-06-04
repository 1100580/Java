/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7ex1;

/**
 *
 * @author i090674
 */
public class Main {

    public static void mostrar(int [][]m){
        int i, j;
        for (i=0; i<m.length; i++) {
            for (j=0; j<m[0].length; j++){
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }
       
    }

    public static void media(int [][]m){
        int i, j;
        double sl, sm=0, ml, mm;
        for (i=0; i<m.length; i++) {
            sl=0;
            for (j=0; j<m[0].length; j++){
                sl=sl+m[i][j];
            }
            sm=sm+sl;
            ml=sl/m[0].length;
            System.out.println("A media da linha "+(i+1)+" é:\n"+ml);
        }
        mm=sm/(m.length*m[0].length);
        System.out.println("A media global da matriz m é: "+mm);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int i, j, x;
        int m[][] = {{1,4,2,1},{9,7,2,2},{1,7,3,5},{2,5,0,3},{2,3,6,0}};
        media(m);
    }

}
