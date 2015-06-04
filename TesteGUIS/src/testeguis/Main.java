/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeguis;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Bessa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TesteGUI jan = new TesteGUI();
        jan.setSize(new Dimension(500,500));
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setVisible(true);
    }
}
