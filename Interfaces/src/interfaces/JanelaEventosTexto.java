package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaEventosTexto extends JFrame{
    private JTextField text1, text2, text3;

    public JanelaEventosTexto() {
        super("Teste de Campos de Texto");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        //Cria campo de texto com tamanho fixo(10)
        text1 = new JTextField(10);
        text1.addActionListener( new TextoListener() );
        c.add(text1);

        //Cria campo de texto com texto por defeito
        text2 = new JTextField("Escrever texto aqui");
        text2.addActionListener( new TextoListener() );
        c.add(text2);

        //Cria campo de texto com texto por defeito 20 colunas
        text3 = new JTextField("Campo nao editavel", 20);
        text3.setEditable(false);
        c.add(text3);

        setSize(350,100);
        setVisible(true);
    }

    //Classe interna para manipulacao de eventos
    class TextoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s="";
            if( e.getSource() == text1 ) {
                s = "text1: " + e.getActionCommand();
                text2.setText(s);
            } else if( e.getSource() == text2 ) {
                s = "text2: " + e.getActionCommand();
                JOptionPane.showMessageDialog(null,s);
            }
        }
    }
}