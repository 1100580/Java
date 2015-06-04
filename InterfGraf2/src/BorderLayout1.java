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
        c.add(b1, BorderLayout.NORTH);
        c.add(b2, BorderLayout.WEST);
        c.add(b3, BorderLayout.CENTER);
        c.add(b4, BorderLayout.EAST);
        c.add(b5, BorderLayout.SOUTH);
        BorderLayout bl = new BorderLayout(20,20);
        c.setLayout(bl);
        c.add(b1, BorderLayout.NORTH);
        c.add(b2, BorderLayout.WEST);
        c.add(b3, BorderLayout.CENTER);
        c.add(b4, BorderLayout.EAST);
        c.add(b5, BorderLayout.SOUTH);
        
        c.setLayout(new BorderLayout(20,20));
        c.add(b1, BorderLayout.NORTH);
        c.add(b2, BorderLayout.WEST);
        c.add(b3, BorderLayout.CENTER);
        
        
        c.setLayout(new BorderLayout());
        JPanel aux1=new JPanel();
            aux1.setLayout(new FlowLayout());
            aux1.add(b1); aux1.add(b2);aux1.add(b3);
            aux1.setBackground(Color.yellow);
        c.add(aux1, BorderLayout.NORTH);
        JPanel aux2=new JPanel();
            aux2.setLayout(new FlowLayout());
            aux2.setBackground(Color.BLUE);
            aux2.add(b4);
        c.add(aux2, BorderLayout.WEST);    
        JPanel aux3=new JPanel();
            aux3.setLayout(new FlowLayout());
            aux3.setBackground(Color.RED);
            aux3.add(b5);        
        c.add(aux3, BorderLayout.CENTER);
        JPanel aux4=new JPanel();
            aux4.setLayout(new FlowLayout());
            aux4.setBackground(Color.BLUE);
            aux4.add(b6);
        c.add(aux4, BorderLayout.EAST);
        JPanel aux5=new JPanel();
            aux5.setLayout(new FlowLayout());
            aux5.add(b7);
            aux5.setBackground(Color.yellow);
        c.add(aux5, BorderLayout.SOUTH);
    }

    public static void main(String [] args) {
        BorderLayout1 jan = new BorderLayout1("Gestor de Posicionamento: BorderLayout");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(800, 600);
        jan.setVisible(true);
    }
}
