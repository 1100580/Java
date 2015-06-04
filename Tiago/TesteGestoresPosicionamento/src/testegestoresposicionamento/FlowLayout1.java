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
import javax.swing.JButton;

public class FlowLayout1 extends JFrame {

    JButton b1 = new JButton("Um");
    JButton b2 = new JButton("Dois");
    JButton b3 = new JButton("Três");
    JButton b4 = new JButton("Quatro");
    JButton b5 = new JButton("Cinco");
    JButton b6 = new JButton("Seis");
    JButton b7 = new JButton("Sete");

    public FlowLayout1(String titulo) {
        super(titulo);
        Container c = getContentPane();
        Dimension d = new Dimension(75, 30);
        c.setPreferredSize(d);
        c.setBackground(Color.cyan);
        FlowLayout fl = new FlowLayout();
        c.setLayout(fl);
        b1.setPreferredSize(d);
        c.add(b1);
        c.add(b2);
        b2.setPreferredSize(d);
        c.add(b3);
        b3.setPreferredSize(d);
        c.add(b4);
        b4.setPreferredSize(d);
        c.add(b5);
        b5.setPreferredSize(d);
        c.add(b6);
        b6.setPreferredSize(d);
        c.add(b7);
        b7.setPreferredSize(d);
    }

//    public static void main(String[] args) {
//        FlowLayout1 jan = new FlowLayout1("Gestor de Posicionamento: FlowLayout");
//        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jan.setSize(400, 200);
//        jan.setVisible(true);
//    }
}

