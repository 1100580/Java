
package flowlayout;
import java.awt.*;
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
        c.setLayout(bl);
        c.add(b1, BorderLayout.NORTH);
        c.add(b2, BorderLayout.WEST);
        c.add(b3, BorderLayout.CENTER);
        c.add(b4, BorderLayout.EAST);
        c.add(b5, BorderLayout.SOUTH);
    }

    public static void main(String [] args) {
        BorderLayout1 jan = new BorderLayout1("Gestor de Posicionamento: BorderLayout");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(400, 200);
        jan.setVisible(true);
    }
}
