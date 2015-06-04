/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

/**
 *
 * @author i090674
 */
public abstract class Animal {

    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void fazRuído();
}
