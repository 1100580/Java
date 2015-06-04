package contasbancarias;

import biblioteca.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogCriarConta extends JDialog {

    private JTextField txtTitular, txtSaldo;
    private JButton btnOk, btnCancelar;
    private Conta conta;

    public DialogCriarConta(Frame pai) {
        super(pai, "Criar Conta", true);
        setLocation(pai.getX() + 100, pai.getY() + 100);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JLabel lbl1 = new JLabel("Titular:");
        p1.add(lbl1);
        txtTitular = new JTextField(20);
        p1.add(txtTitular);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        JLabel lbl2 = new JLabel("Saldo: ");
        p2.add(lbl2);
        txtSaldo = new JTextField(10);
        p2.add(txtSaldo);

        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        btnOk = new JButton("OK");
        getRootPane().setDefaultButton(btnOk);
        btnOk.addActionListener(new TrataEvento());
        p3.add(btnOk);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new TrataEvento());
        p3.add(btnCancelar);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }

    public Conta showDialog() {
        setVisible(true);
        return conta;
    }

    private class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnOk) {
                if (txtTitular.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tem que introduzir o nome do titular.", "Criação de Conta Bancária", JOptionPane.WARNING_MESSAGE);
                    txtTitular.requestFocus();
                } else {
                    String titular = txtTitular.getText();
                    float saldo;
                    try {
                        saldo = Float.parseFloat(txtSaldo.getText());
                        if (saldo < 0) {
                            JOptionPane.showMessageDialog(null, "Tem que introduzir um valor não negativo no saldo.", "Criação de Conta Bancária", JOptionPane.WARNING_MESSAGE);
                            txtSaldo.requestFocus();
                        } else {
                            conta = new Conta(titular, saldo);
                            setVisible(false);
                        }
                    } catch (java.lang.NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Tem que introduzir um valor numérico no saldo.", "Criação de Conta Bancária", JOptionPane.WARNING_MESSAGE);
                        txtSaldo.requestFocus();
                    }
                }
            } else {
                setVisible(false);
            }
        }
    }
}
