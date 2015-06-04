package gui;

import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class ContaClicks extends JFrame {
    private int numClicks = 0;
    private JLabel l;
    
    public ContaClicks(String titulo) {
        super(titulo);
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = this.getContentPane();
        //...por defeito o contentPane do JFrame é BorderLayout
        
        
        //...por defeito o JPanel é FlowLayout
        JPanel p1 = new JPanel(new BorderLayout());
        c.add(p1, BorderLayout.CENTER);

        l = new JLabel("Número de clicks: 0");
        l.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(l, BorderLayout.CENTER);
        
        JPanel p2 = new JPanel();
        c.add(p2, BorderLayout.SOUTH);
        
        JButton b = new JButton("Clica aqui!");
        b.setMnemonic(KeyEvent.VK_C);
        b.addActionListener(new BotaoListener());
        p2.add(b);
    }
    
    private class BotaoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            l.setText("Número de clicks: " + ++numClicks);
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        ContaClicks app = new ContaClicks("Contador de clicks");
        //app.pack();
        app.setVisible(true);
    }
}
