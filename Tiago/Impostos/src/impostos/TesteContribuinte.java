/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impostos;

/**
 *
 * @author i090674
 */
public class TesteContribuinte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contribuinte vec[] = new Contribuinte[20];
        vec[0] = new Desempregado("Joao Vitor", "Rua do gato da vizinha", 50000, 30000, 10);
        vec[1] = new Reformado("Antonio Miguel", "Rua dos velhos", 500000, 100000);
        vec[2] = new TrabOutrem("Carlos Miguel", "Rua dos gafanhotos gigantes", 10000, 600, "Spam Company");
        vec[3] = new TrabPropria("Manel Bocas", "Rua dos coisos", 100000, 5000, "Carpinteiro");
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] != null) {
                System.out.println(vec[i].toString());
            }
        }
        System.out.println("");
        System.out.println("Desempregados:");
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] instanceof Desempregado) {
                System.out.println(vec[i].toString());
            }
        }
    }
}
