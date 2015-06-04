import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaEventosBotao extends JFrame{

    public JanelaEventosBotao() {
        super("Teste de Botoes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        //Cria botao com msg
        JButton bt1 = new JButton("Botao 1");
        bt1.setMnemonic(KeyEvent.VK_B);
        bt1.setForeground(Color.BLUE);
        bt1.setPreferredSize(new Dimension(80, 50));
        bt1.addActionListener( new BotaoListener() );
        c.add(bt1);

        //Cria botao com imagem
        Icon ic1 = new ImageIcon("c:\\Windows\\web\\tips.gif");
        Icon ic2 = new ImageIcon("c:\\Windows\\web\\bullet.gif");

        JButton bt2 = new JButton("Botao 2", ic1);
        bt2.setPreferredSize(new Dimension(110, 50));
        bt2.setToolTipText("Botao 2");
        bt2.setRolloverIcon(ic2);   //muda a imagem quando passa o rato.
        bt2.addActionListener( new BotaoListener() );
        c.add(bt2);

        setSize(300, 300);
        setVisible(true);
    }

    //classe interna
    class BotaoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Carregou em " +
                                                          e.getActionCommand());
        }
    }
}

