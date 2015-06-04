package contasbancarias;


import biblioteca.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DialogConsultarConta extends JDialog {

    private JTextField txtNrConta, txtTitular, txtSaldo;
    private JButton btnOk;
    private JComboBox cmbContas;

    public DialogConsultarConta(Frame pai) {
        super(pai, "Criar Conta", true);

        setLocation(pai.getX() + 100, pai.getY() + 100);

        JPanel p0 = new JPanel();
        JLabel lbl0 = new JLabel("Conta: ");
        p0.add(lbl0);

        cmbContas = new JComboBox(nrsETitulares());
        cmbContas.setSelectedIndex(-1);
        cmbContas.setMaximumRowCount(3);
        cmbContas.addActionListener(new TrataEvento());
        p0.add(cmbContas);

        JPanel p1 = new JPanel(new BorderLayout());

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl1 = new JLabel("Nr.Conta:");
        p2.add(lbl1);
        txtNrConta = new JTextField(10);
        txtNrConta.setEditable(false);
        p2.add(txtNrConta);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl2 = new JLabel("Titular:    ");
        p3.add(lbl2);
        txtTitular = new JTextField(20);
        txtTitular.setEditable(false);
        p3.add(txtTitular);

        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        JLabel lbl3 = new JLabel("Saldo:     ");
        p4.add(lbl3);
        txtSaldo = new JTextField(10);
        txtSaldo.setEditable(false);
        p4.add(txtSaldo);

        JPanel p5 = new JPanel();
        btnOk = new JButton("OK");
        getRootPane().setDefaultButton(btnOk);
        btnOk.addActionListener(new TrataEvento());
        p5.add(btnOk);

        p1.add(p2, BorderLayout.NORTH);
        p1.add(p3, BorderLayout.CENTER);
        p1.add(p4, BorderLayout.SOUTH);

        add(p0, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }

    public void showDialog(){
        setVisible(true);
    }

    private class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cmbContas) {
                String nrEtitular = (String) (cmbContas.getSelectedItem());
                String[] aux = nrEtitular.split("-");
                int nrConta = Integer.parseInt(aux[0].trim());

                Conta conta = Contas.getContaPorNr(nrConta);
                txtNrConta.setText(String.valueOf(conta.getNrConta()));
                txtTitular.setText(conta.getTitular());
                txtSaldo.setText(String.valueOf(conta.getSaldo()));
            } else {
                setVisible(false);
            }
        }
    }

    private Object[] nrsETitulares() {
        ArrayList a = new ArrayList();
        for (Conta c : Contas.getContas()) {
            String s = c.getNrConta() + " - " + c.getTitular();
            a.add(s);
        }
        return a.toArray();
    }
    
}
