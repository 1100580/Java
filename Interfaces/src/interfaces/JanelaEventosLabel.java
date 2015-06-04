package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaEventosLabel extends JFrame {
    private JLabel label1, label2, label3;

    public JanelaEventosLabel() {
        super("Teste de Labels");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );

        //Construtor de JLabel com um string
        label1 = new JLabel("TEXTO");
        //indicações de o que faz como o rollover tips do ff
        label1.setToolTipText("Esta e a label 1");

        //Juntar evento, quando clica na label escreve mensagem
        label1.addMouseListener( new Label1Listener() );
        c.add(label1);

        //Construtor de JLabel com um string Icon e argumentos alinhados
        Icon ic = new ImageIcon("c:\\windows\\web\\tips.GIF");
        label2 = new JLabel("Texto e Icon", ic, SwingConstants.RIGHT);
        label2.setForeground(Color.RED);
        label2.setFont( new Font("TimesRoman", Font.BOLD, 20) );
        label2.setToolTipText("Esta e a label 2");
        label2.setPreferredSize( new Dimension(200,100) );

        //Juntar evento, quando passa o rato pela label muda a cor
        label2.addMouseListener( new Label2Listener() );
        c.add(label2);

        //Construtor de JLabel sem argumentos
        label3 = new JLabel();
        label3.setText("Icon e texto no fim");
        label3.setIcon(ic);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("Esta e a label 3");
        c.add(label3);

        setSize(400, 200);
        setVisible(true);
    }

    //Classe interna para manipular click do rato
    class Label1Listener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            String texto = "Clicou na label cujo texto e: ";
            texto += ((JLabel)e.getSource()).getText();
            JOptionPane.showMessageDialog(null,texto);
        }
    }

    //Classe interna para manipular passagem do rato
    class Label2Listener extends MouseAdapter {
        public void mouseEntered(MouseEvent e) {
            ((JLabel)e.getSource()).setForeground(Color.BLACK);
        }
        public void mouseExited(MouseEvent e) {
            ((JLabel)e.getSource()).setForeground(Color.RED);
        }
    }
}
