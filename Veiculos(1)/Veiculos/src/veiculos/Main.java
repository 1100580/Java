/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package veiculos;

/**
 *
 * @author Miguel Vilaça
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stand s1 = new Stand();
        Utilitario u1 = new Utilitario("Toyota", "1", 22, 100, 10);
        // String marca, String matricula, double cilindrada, double preco, int consumo
        Utilitario u2 = new Utilitario("Branco", "2", 23, 101, 11);
        Utilitario u3 = new Utilitario("Azul", "3", 24, 102, 12);
        Utilitario u4 = new Utilitario("Verde", "4", 25, 103, 13);
        Comercial c1 = new Comercial("Toyota", "1", 22, 100, 10);
        s1.add(u1);
        s1.add(u2);
        s1.add(u3);
        s1.add(u4);
        s1.add(c1);
        s1.Listar();



    }

}
