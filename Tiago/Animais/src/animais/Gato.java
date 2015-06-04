/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

/**
 *
 * @author i090674
 */
public class Gato extends AnimalEstimação {

    public Gato(String nome) {
        super(nome);
    }

    public void fazRuído() {
        System.out.println(getNome() + " a miar... ");
    }

    public void caçaRatos() {
        System.out.println(getNome() + " a caçar ratos.");
    }
}
