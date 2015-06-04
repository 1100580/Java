package vencimentosGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DialogTrabCom extends JDialog {
    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtVendas;
    private JTextField txtComissao;
    private TrabCom tc;
    
    public DialogTrabCom(Frame pai, String titulo) {
        super(pai, titulo, true);
        this.setLocation(pai.getX()+100, pai.getY()+100);
        
        Container c = getContentPane();
        
        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new GridLayout(4,1));
            p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            JPanel p11 = new JPanel();
                label = new JLabel("Nome:              ");
                p11.add(label);
                txtNome = new JTextField(20);
                p11.add(txtNome);
            p1.add(p11);
            
            JPanel p12 = new JPanel();
                label = new JLabel("Salário:            ");
                p12.add(label);
                txtSalario = new JTextField(20);
                p12.add(txtSalario);
            p1.add(p12);
            
            JPanel p13 = new JPanel();
                label = new JLabel("Total Vendas: ");
                p13.add(label);
                txtVendas = new JTextField(20);
                p13.add(txtVendas);
            p1.add(p13);
            
            JPanel p14 = new JPanel();
                label = new JLabel("Comissão (%):");
                p14.add(label);
                txtComissao = new JTextField(20);
                p14.add(txtComissao);
            p1.add(p14);
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
                    JOptionPane.showMessageDialog(null, "Tem que introduzir o nome do novo Trabalhador à Comissão.", "Criação de um novo Trabalhador à Comissão", JOptionPane.WARNING_MESSAGE);
                    txtNome.requestFocus();
                }
                else {
                    String nome = txtNome.getText();
                    float salario;
                    
                    try { salario = Float.parseFloat(txtSalario.getText()); }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no campo 'Salário'.", "Criação de um novo Trabalhador à Comissão", JOptionPane.WARNING_MESSAGE);
                        txtSalario.requestFocus();
                        return;
                    }
                    
                    float vendas;
                    try { vendas = Float.parseFloat(txtVendas.getText()); }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no campo 'Total Vendas'.", "Criação de um novo Trabalhador à Comissão", JOptionPane.WARNING_MESSAGE);
                        txtVendas.requestFocus();
                        return;
                    }
                    
                    float comissao;
                    try {
                        comissao = Float.parseFloat(txtComissao.getText())/100;
                    }
                    catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no campo 'Comissão'.", "Criação de um novo Trabalhador à Comissão", JOptionPane.WARNING_MESSAGE);
                        txtComissao.requestFocus();
                        return;
                    }

                    tc = new TrabCom(nome, salario, vendas, comissao);
                    
                    setVisible(false);
                }
            }
            else
                setVisible(false);
        }
    }
    
    public TrabCom showDialog() {
        // criação de um novo trabalhador à comissão
        setVisible(true);
        
        return tc;
    }

    public TrabCom showDialog(Trabalhador obj) {
        // alteração dos dados de um trabalhador à comissão
        pack();        
        
        txtNome.setText(obj.getNome());
        txtSalario.setText(  String.valueOf(  ((TrabCom)obj).getSalario()  )  );
        txtVendas.setText(  String.valueOf(  ((TrabCom)obj).getVendas()  )  );
        txtComissao.setText( String.valueOf(((TrabCom)obj).getComissao()*100) );
        
        setVisible(true);
        
        return tc;
    }
}
