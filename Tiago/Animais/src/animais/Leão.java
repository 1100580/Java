/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package animais;

/**
 *
 * @author i090674
 */
public class Leão extends Animal {
public Leão(String nome) {
super(nome);
}
public void fazRuído() {
System.out.println(getNome() + " a rugir... ");
}
}
