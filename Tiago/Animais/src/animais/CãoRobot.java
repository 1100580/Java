/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

/**
 *
 * @author i090674
 */
public class CãoRobot implements Brincar {

    String nome;

    public CãoRobot(String nome) {
        this.nome = nome;
    }

    public void brinca() {
        System.out.println(nome + " a brincar.");
    }
}
