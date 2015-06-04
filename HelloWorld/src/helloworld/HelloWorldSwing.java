package helloworld;

import java.awt.*;
import javax.swing.*;

public class HelloWorldSwing extends JFrame {

    public HelloWorldSwing(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        JLabel j1 = new JLabel("Hello World");
        c.add(j1, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        HelloWorldSwing app = new HelloWorldSwing("HelloWorldSwing");
        app.setSize(250, 100);
        app.setLocation(100, 100);
        app.setVisible(true);
    }
}
