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
import java.util.Locale;
import javax.swing.*;

public class BorderLayout1 extends JFrame {

    JButton b1 = new JButton("Um");
    JButton b2 = new JButton("Dois");
    JButton b3 = new JButton("Três");
    JButton b4 = new JButton("Quatro");
    JButton b5 = new JButton("Cinco");
    JButton b6 = new JButton("Seis");
    JButton b7 = new JButton("Sete");

    public BorderLayout1(String titulo) {
        super(titulo);
        Container c = getContentPane();
        c.setBackground(Color.cyan);
        BorderLayout bl = new BorderLayout();
        FlowLayout f1 = new FlowLayout();
//        FlowLayout f2= new FlowLayout();
//        FlowLayout f3= new FlowLayout();
        c.setLayout(bl);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.YELLOW);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.BLUE);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.RED);
        JPanel p4 = new JPanel();
        p4.setBackground(Color.BLUE);
        JPanel p5 = new JPanel();
        p5.setBackground(Color.YELLOW);
        c.add(p1, BorderLayout.NORTH);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        c.add(p2, BorderLayout.WEST);
        p2.add(b4);
        c.add(p3, BorderLayout.CENTER);
        p3.add(b5);
        c.add(p4, BorderLayout.EAST);
        p4.add(b6);
        c.add(p5, BorderLayout.SOUTH);
        p5.add(b7);
//        c.add(b3, BorderLayout.CENTER);
//        c.add(b4, BorderLayout.EAST);
//        c.add(b5, BorderLayout.SOUTH);
    }

//    public static void main(String[] args) {
//        BorderLayout1 jan = new BorderLayout1("Gestor de Posicionamento: BorderLayout");
//        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jan.setSize(400, 200);
//        jan.setVisible(true);
//    }
}


