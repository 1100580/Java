/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

/**
 *
 * @author i090674
 */
public class Cão extends AnimalEstimação {

    public Cão(String nome) {
        super(nome);
    }

    public void fazRuído() {
        System.out.println(getNome() + " a ladrar.");
    }

    public void caçaGatos() {
        System.out.println(getNome() + " a caçar gatos.");
    }
}
