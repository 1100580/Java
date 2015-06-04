package vencimentosGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DialogTrabHora extends JDialog {
    private JTextField txtNome;
    private JTextField txtNHoras;
    private JTextField txtPagHora;
    private TrabHora th;
    
    public DialogTrabHora(Frame pai, String titulo) {
        super(pai, titulo, true);
        this.setLocation(pai.getX()+100, pai.getY()+100);
        
        Container c = getContentPane();
        
        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new GridLayout(3,1));
            p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            JPanel p11 = new JPanel();
                label = new JLabel("Nome:           ");
                p11.add(label);
                txtNome = new JTextField(20);
                p11.add(txtNome);
            p1.add(p11);
            
            JPanel p12 = new JPanel();
                label = new JLabel("N� de Horas:");
                p12.add(label);
                txtNHoras = new JTextField(20);
                p12.add(txtNHoras);
            p1.add(p12);
            
            JPanel p13 = new JPanel();
                label = new JLabel("Pag. p/ Hora:");
                p13.add(label);
                txtPagHora = new JTextField(20);
                p13.add(txtPagHora);
            p1.add(p13);
        c.add(p1, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
            p2.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
            
            botao = new JButton("OK");
            getRootPane().setDefaultButton(botao);
            botao.addActionListener(new TrataEvento());
            p2.add(botao);
        
            botao = new JButton("Cancelar");
            botao.addActionListener(new TrataEvento());
            p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);
        
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }
    
    class TrataEvento implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("OK".equals(e.getActionCommand())) {
                if ("".equals(txtNome.getText())) {
                    JOptionPane.showMessageDialog(null,
                        "Tem que introduzir o nome do novo Trabalhador � Hora.",
                                        "Cria��o de um novo Trabalhador � Hora",
                                                   JOptionPane.WARNING_MESSAGE);
                    txtNome.requestFocus();
                }
                else {
                    String nome = txtNome.getText();
                    int nHoras;
                    
                    try { nHoras = Integer.parseInt(txtNHoras.getText()); }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor num�rico no campo 'N� de Horas'.", "Cria��o de um novo Trabalhador � Hora", JOptionPane.WARNING_MESSAGE);
                        txtNHoras.requestFocus();
                        return;
                    }
                    
                    float pagHora;
                    try { pagHora = Float.parseFloat(txtPagHora.getText()); }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor num�rico no campo 'Pag. p/ Hora'.", "Cria��o de um novo Trabalhador � Hora", JOptionPane.WARNING_MESSAGE);
                        txtPagHora.requestFocus();
                        return;
                    }
                    
                    th = new TrabHora(nome, nHoras, pagHora);
                    
                    setVisible(false);
                }
            }
            else
                setVisible(false);
        }
    }
    
    public TrabHora showDialog() {
        // cria��o de um novo trabalhador � hora
        setVisible(true);
        
        // Como o JDialog � modal s� continua quando o JDialog for escondido com
        // a instru��o dialog.setVisible(false), ou seja, quando for premido um
        // bot�o
        
        return th;
    }

    public TrabHora showDialog(Trabalhador obj) {
        // altera��o dos dados de um trabalhador � hora
        pack();        
        
        txtNome.setText(obj.getNome());
        txtNHoras.setText(  String.valueOf(  ((TrabHora)obj).getNHoras()  )  );
        txtPagHora.setText(  String.valueOf( ((TrabHora)obj).getPagHora() )  );
        
        show();
        
        return th;
    }
}
