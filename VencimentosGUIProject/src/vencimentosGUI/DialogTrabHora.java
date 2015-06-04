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
                label = new JLabel("Nº de Horas:");
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
                        "Tem que introduzir o nome do novo Trabalhador à Hora.",
                                        "Criação de um novo Trabalhador à Hora",
                                                   JOptionPane.WARNING_MESSAGE);
                    txtNome.requestFocus();
                }
                else {
                    String nome = txtNome.getText();
                    int nHoras;
                    
                    try { nHoras = Integer.parseInt(txtNHoras.getText()); }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no campo 'Nº de Horas'.", "Criação de um novo Trabalhador à Hora", JOptionPane.WARNING_MESSAGE);
                        txtNHoras.requestFocus();
                        return;
                    }
                    
                    float pagHora;
                    try { pagHora = Float.parseFloat(txtPagHora.getText()); }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no campo 'Pag. p/ Hora'.", "Criação de um novo Trabalhador à Hora", JOptionPane.WARNING_MESSAGE);
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
        // criação de um novo trabalhador à hora
        setVisible(true);
        
        // Como o JDialog é modal só continua quando o JDialog for escondido com
        // a instrução dialog.setVisible(false), ou seja, quando for premido um
        // botão
        
        return th;
    }

    public TrabHora showDialog(Trabalhador obj) {
        // alteração dos dados de um trabalhador à hora
        pack();        
        
        txtNome.setText(obj.getNome());
        txtNHoras.setText(  String.valueOf(  ((TrabHora)obj).getNHoras()  )  );
        txtPagHora.setText(  String.valueOf( ((TrabHora)obj).getPagHora() )  );
        
        show();
        
        return th;
    }
}
