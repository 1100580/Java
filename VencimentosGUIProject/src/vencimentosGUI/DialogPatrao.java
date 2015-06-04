package vencimentosGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DialogPatrao extends JDialog {
    private JTextField txtNome;
    private JTextField txtSalario;
    private Patrao p;
    
    public DialogPatrao(Frame pai, String titulo) {
        super(pai, titulo, true);
        this.setLocation(pai.getX()+100, pai.getY()+100);

        Container c = getContentPane();
        
        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new GridLayout(2,1));
            p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            JPanel p11 = new JPanel();
                label = new JLabel("Nome:  ");
                p11.add(label);
                txtNome = new JTextField(20);
                p11.add(txtNome);
            p1.add(p11);
            
            JPanel p12 = new JPanel();
                label = new JLabel("Salário:");
                p12.add(label);
                txtSalario = new JTextField(20);
                p12.add(txtSalario);
            p1.add(p12);
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
                    JOptionPane.showMessageDialog(null,"Tem que introduzir o nome do novo Patrão.","Criação de um novo Patrão", JOptionPane.WARNING_MESSAGE);
                    txtNome.requestFocus();
                }
                else {
                    String nome = txtNome.getText();
                    float salario;
                    
                    try {
                        salario = Float.parseFloat(txtSalario.getText());
                    }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no campo 'Salário'.", "Criação de um novo Patrão", JOptionPane.WARNING_MESSAGE);
                        txtSalario.requestFocus();
                        return;
                    }
                    p = new Patrao(nome, salario);
                    
                    setVisible(false);
                }
            }
            else
                setVisible(false);
        }
    }
    
    public Patrao showDialog() {
        // criação de um novo patrão
        setVisible(true);
        
        return p;
    }
    
    public Patrao showDialog(Trabalhador obj) {
        // alteração dos dados de um patrão
        pack();        
        
        txtNome.setText(obj.getNome());
        txtSalario.setText(  String.valueOf(  ((Patrao)obj).getSalario()  )  );
        
        setVisible(true);
        
        return p;
    }
}
