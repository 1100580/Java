package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorldSwing extends JFrame {

    public HelloWorldSwing(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = this.getContentPane();
        
        JLabel l = new JLabel("Hello World!");
        l.setForeground(Color.BLUE);
        l.setFont(new Font("Serif",Font.BOLD,20));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(l,BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        HelloWorldSwing app = new HelloWorldSwing("HelloWorldSwing");
        
        app.setSize(250,100); //app.pack()
        app.setLocation(100,100);
        app.setVisible(true); //app.show() -- deprecated!
    }
}
