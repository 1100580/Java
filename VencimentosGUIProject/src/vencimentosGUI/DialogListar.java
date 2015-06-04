package vencimentosGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class DialogListar extends JDialog {
    
    public DialogListar(Frame pai, String titulo, ArrayList trabsList) {
        super(pai, titulo, true);
        this.setLocation(pai.getX()+100, pai.getY()+100);

        Container c = getContentPane();
        
        JPanel p1 = new JPanel(new BorderLayout());
            p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            DefaultListModel listModel;
            listModel = new DefaultListModel();
            JList list = new JList(listModel);
            for( int i=0; i<trabsList.size(); i++)
                listModel.addElement(trabsList.get(i));
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            JScrollPane scroll = new JScrollPane(list);
            p1.add(scroll, BorderLayout.CENTER);
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
            setVisible(false);
        }
    }
    
    public void showDialog() {
        setVisible(true);
    }
}
