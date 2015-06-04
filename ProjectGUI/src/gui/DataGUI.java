package gui;

import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.StringTokenizer;

public class DataGUI extends JFrame {
    private JTextField txtData;
    private JTextField txtDiaDaSemana;
    private JLabel lblDataPorExtenso;
    private JButton butDiaDaSemana;
    private JButton butDataPorExtenso;
    private JButton butLimpar;
    
    public DataGUI(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        JPanel p1 = new JPanel(new GridLayout(3,1));
        p1.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        c.add(p1,BorderLayout.CENTER);
        
        
        JPanel p11 = new JPanel();
            JLabel lblData = new JLabel("Data (aaaa/mm/dd):");
            p11.add(lblData);
            txtData = new JTextField(10);
            txtData.addActionListener(new TextoListener());
            p11.add(txtData);
        p1.add(p11);
        
        JPanel p12 = new JPanel();
            JLabel lblDiaSem = new JLabel("Dia da semana:");
            p12.add(lblDiaSem);
            txtDiaDaSemana = new JTextField(12);
            txtDiaDaSemana.setEnabled(false);
            p12.add(txtDiaDaSemana);
        p1.add(p12);
        
        JPanel p13 = new JPanel();
            lblDataPorExtenso = new JLabel(" ");
            p13.add(lblDataPorExtenso);
        p1.add(p13);
        
        
        JPanel p2 = new JPanel();
            p2.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
            
            butDiaDaSemana = new JButton("Dia da Semana");
            butDiaDaSemana.setMnemonic(KeyEvent.VK_S);
            butDiaDaSemana.setToolTipText("Determina o dia da semana.");
            butDiaDaSemana.addActionListener(new BotaoListener());
            p2.add(butDiaDaSemana);
            
            butDataPorExtenso = new JButton("Data por Extenso");
            butDataPorExtenso.setMnemonic(KeyEvent.VK_E);
            butDataPorExtenso.setToolTipText("Imprime a data por extenso.");
            butDataPorExtenso.addActionListener(new BotaoListener());
            p2.add(butDataPorExtenso);
            
            butLimpar = new JButton("Limpar");
            butLimpar.setMnemonic(KeyEvent.VK_L);
            butLimpar.setToolTipText("Limpa a data.");
            butLimpar.addActionListener(new BotaoListener());
            p2.add(butLimpar);
        c.add(p2,BorderLayout.SOUTH);
    }

    private Data getData() {
        String s=txtData.getText();
        String[] a;
        a=s.split("/");
        return new Data( Integer.parseInt(a[0]),
                         Integer.parseInt(a[1]),
                         Integer.parseInt(a[2]));
    }
    
    private class BotaoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if (obj == butDiaDaSemana)
                txtDiaDaSemana.setText(getData().diaDaSemana());
            else if (obj == butDataPorExtenso)
                lblDataPorExtenso.setText(getData().toString());
            else if (obj == butLimpar) {
                txtData.setText("");
                txtData.requestFocus();
                txtDiaDaSemana.setText("");
                lblDataPorExtenso.setText(" ");
            }
        }
    }
    
    private class TextoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            txtDiaDaSemana.setText(getData().diaDaSemana());
            lblDataPorExtenso.setText(getData().toString());
        }
    }
    
    public static void main(String[] args) throws Exception {
        JFrame.setDefaultLookAndFeelDecorated(true);
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        
        DataGUI app = new DataGUI("Data GUI");
        app.pack();
        app.setVisible(true);
    }
}
