/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calcombinatorio;

public class TesteCalComb {
    public static void main(String[] args) {
        int n = 5;
        int p = 4;
        long res = CalCombinatorio.combinacoes(n, p);
        System.out.println("Res:" + res);
        
        res = CalCombinatorio.arranjos(n, p);
        System.out.println("Res: " + res);
        
    }
}
