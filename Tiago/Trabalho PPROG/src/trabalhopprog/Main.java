/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Tiago
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayPerguntas a = new ArrayPerguntas();
        Ficheiro.LerFicheiro("perguntas.txt", a);
        Menu m = new Menu("Menu", a);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        m.setSize(700, 580);
    }
}


