/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

/**
 *
 * @author i090674
 */
public abstract class AnimalEstimação extends Animal implements Brincar {

    public AnimalEstimação(String nome) {
        super(nome);
    }

    public void brinca() {
        System.out.println(getNome() + " a brincar.");
    }

    public void caçaGatos() {
        System.out.println(getNome() + " a caçar gatos.");
    }
}
