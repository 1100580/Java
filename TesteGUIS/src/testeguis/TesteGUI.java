package testeguis;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesteGUI extends JFrame {

    public TesteGUI(){
        super("Teste");
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(5,5));
        c.setBackground(Color.red);
        
        for (int i = 0; i < 25; i++) {
            c.add(new JButton());
        }
        
        c.setVisible(true);
    }
}
