package vencimentosGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class DialogCalcularVencimento extends JDialog {
    private JLabel vencimento;
    
    public DialogCalcularVencimento(Frame pai, String titulo, ArrayList trabsList) {
        super(pai, titulo, true);
        this.setLocation(pai.getX()+100, pai.getY()+100);

        Container c = getContentPane();
        
        JPanel p1 = new JPanel(new GridLayout(2,1,0,20));
            p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
            JPanel p11 = new JPanel();
                JLabel label = new JLabel("Trabalhador:");
                p11.add(label);
                JComboBox combo = new JComboBox(trabsList.toArray());
                combo.setSelectedIndex(-1);
                combo.setMaximumRowCount(3);
                combo.addActionListener(new TrataEvento());
                p11.add(combo);
            p1.add(p11);        

            JPanel p12 = new JPanel();
                vencimento = new JLabel(" ");
                p12.add(vencimento);
            p1.add(p12);
        c.add(p1, BorderLayout.CENTER);
        
        JPanel p2 = new JPanel();
            p2.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
            
            JButton botao = new JButton("OK");
            getRootPane().setDefaultButton(botao);
            botao.addActionListener(new TrataEvento());
            p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);
        
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }
    
    class TrataEvento implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("OK".equals(e.getActionCommand()))
                setVisible(false);
            else {
                JComboBox cb = (JComboBox) e.getSource();
                Trabalhador trab = (Trabalhador) cb.getSelectedItem();
                vencimento.setText( "Vencimento: " + trab.vencimento() + " euros" );
            }
        }
    }
    
    public void showDialog() {
        setVisible(true);
    }
}
