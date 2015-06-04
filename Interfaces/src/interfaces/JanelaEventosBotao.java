package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaEventosBotao extends JFrame{

    public JanelaEventosBotao() {
        //titulo
        super("Teste de Botoes");
        //fecha mesmo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //o Container é um contentor que tem e organiza os objectos criados
        Container c = getContentPane();
        //A maneira como os botoes sao colocados
        c.setLayout(new FlowLayout());

        //Cria botao com msg
        JButton bt1 = new JButton("Botao 1");
        //cria um atalho (alt+b) em alternativa ao clique
        bt1.setMnemonic(KeyEvent.VK_B);
        bt1.setForeground(Color.BLUE);
        bt1.setPreferredSize(new Dimension(80, 50));
        //Existe aqui a classe BotaoListener que define o que faz o clique
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
            JOptionPane.showMessageDialog(null, "Carregou em " + e.getActionCommand());
        }
    }
}
