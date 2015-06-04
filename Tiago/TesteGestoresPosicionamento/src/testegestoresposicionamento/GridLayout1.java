/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testegestoresposicionamento;

/**
 *
 * @author i090674
 */
import java.awt.*;
import javax.swing.*;

public class GridLayout1 extends JFrame {

    private JButton b1 = new JButton("Um");
    private JButton b2 = new JButton("Dois");
    private JButton b3 = new JButton("Três");
    private JButton b4 = new JButton("Quatro");
    private JButton b5 = new JButton("Cinco");
    private JButton b6 = new JButton("Seis");
    private JButton b7 = new JButton("Sete");

    public GridLayout1(String titulo) {
        super(titulo);
        Container c = getContentPane();
        c.setBackground(Color.cyan);
        GridLayout g = new GridLayout(7, 1);
        FlowLayout f = new FlowLayout();
        JPanel j = new JPanel(g);
        JPanel j2 = new JPanel(f);
        j2.setBackground(Color.YELLOW);
        f.setHgap(0);
        f.setVgap(0);
        g.setVgap(20);
        j.setBackground(Color.BLACK);
        c.add(j2, BorderLayout.WEST);
        j2.add(j);
        j.add(b1);
        j.add(b2);
        j.add(b3);
        j.add(b4);
        j.add(b5);
        j.add(b6);
        j.add(b7);
        }

    public static void main(String args[]) {
        GridLayout1 apl = new GridLayout1("Gestor de Posicionamento: GridLayout");
        apl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apl.setSize(400, 200);
        apl.setVisible(true);
    }
}

