/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contaclicks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author i090674
 */
public class Click extends JFrame {

    JLabel j = new JLabel();
    double cont=999999999;

    public Click(String titulo) {
        super(titulo);
        Container c = new Container();
        c = getContentPane();
        c.setBackground(Color.lightGray);
        BorderLayout b = new BorderLayout();
        j.setText("Numero de clicks = " + cont);
        c.setLayout(b);
        j.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(j, BorderLayout.CENTER);
        FlowLayout f = new FlowLayout();
        JPanel jp = new JPanel();
        jp.setLayout(f);
        jp.setBackground(Color.lightGray);
        JButton bt = new JButton("Clica Aqui!");
        jp.add(bt);
        c.add(jp, BorderLayout.SOUTH);
        TrataEv t = new TrataEv();
        bt.addActionListener(t);
    }

    class TrataEv implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           j.setText("Numero de clicks = " + (++cont));

        }
    }

    public static void main(String[] args) {
        Click h = new Click("Hello");
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h.setVisible(true);
        h.setSize(200, 200);
    }
}
