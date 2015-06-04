/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ficha3;

/**
 *
 * @author Lobito
 */
public class TesteComplexo {

    public static void main(String[] args) {
        Complexo c1 = new Complexo(3,4);
        Complexo c2 = new Complexo(2,5);

        System.out.println(c1.Somar(c2));
        System.out.println(c1.Subtrair(c2));
        System.out.println(c1.Multiplicar(c2));
    }
}
