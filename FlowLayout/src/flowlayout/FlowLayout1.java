
package flowlayout;
import java.awt.*;
import javax.swing.*;

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
            c.setBackground(Color.darkGray);
            FlowLayout fl = new FlowLayout();
            c.setLayout(fl);
            c.add(b1);
            c.add(b2);
            c.add(b3);
            c.add(b4);
            c.add(b5);
            c.add(b6);
            c.add(b7);
	}

        public static void main(String [] args) {
            FlowLayout1 jan = new FlowLayout1("Gestor de Posicionamento: FlowLayout");
            jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jan.setSize(400, 200);
            jan.setVisible(true);
        }
}