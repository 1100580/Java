/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        Cão c1 = new Cão("Bart");
        Cão c2 = new Cão("Fido");
        Gato g1 = new Gato("Bolinhas");
        CãoRobot r1 = new CãoRobot("CãoRobot");
        Leão l1 = new Leão("Simba");
        ArrayList<Brincar> animais = new ArrayList<Brincar>();
        animais.add(c1);
        animais.add(c2);
        animais.add(g1);
        animais.add(r1);
    
        for (int i = 0; i < animais.size(); i++) {
            Brincar c = animais.get(i);
            c.brinca();
        }
    }
}
