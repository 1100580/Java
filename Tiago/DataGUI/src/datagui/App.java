/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datagui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author i090674
 */
public class App extends JFrame {

    public App(String titulo) {
        super(titulo);
        Container c = new Container();
        c = getContentPane();
        c.setBackground(Color.lightGray);
        //BorderLayout b = new BorderLayout();
        FlowLayout f1 = new FlowLayout();
        FlowLayout f2 = new FlowLayout();
        FlowLayout f3 = new FlowLayout();
        
        GridLayout g = new GridLayout(3, 1);
        //c.setLayout(b);
        JPanel jp1 = new JPanel();
        jp1.setLayout(g);
        c.add(jp1, BorderLayout.CENTER);

        JPanel jp2 = new JPanel();
        jp2.setLayout(f1);
        jp1.add(jp2);

        JPanel jp3 = new JPanel();
        jp3.setLayout(f2);
        jp1.add(jp3);

        JPanel jp4 = new JPanel();
        jp4.setLayout(f3);
        jp1.add(jp4);

        FlowLayout f = new FlowLayout();
        JPanel jp5 = new JPanel();
        jp5.setLayout(f);
        jp5.setBackground(Color.lightGray);
//        JButton bt = new JButton("Clica Aqui!");
//        jp.add(bt);
        c.add(jp2, BorderLayout.SOUTH);
//        TrataEv t = new TrataEv();
//        bt.addActionListener(t);
        
    }

    public static void main(String[] args) {
        App h = new App("Data");
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h.setVisible(true);
        h.setSize(500, 500);
    }
}
