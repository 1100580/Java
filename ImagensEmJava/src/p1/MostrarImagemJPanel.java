package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarImagemJPanel extends JFrame {

    private String[] nomes = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    private Image[] imagens;
    private JButton[] botoes;
    private JPanel painel4;
    private int indiceCorrente = 0;

    public MostrarImagemJPanel(String titulo) {
        super(titulo);

        painel4 = new Painel4();
        JPanel pSul = new JPanel();

        botoes = new JButton[nomes.length];
        imagens = new Image[nomes.length];
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (int i = 0; i < nomes.length; i++) {
            java.net.URL urlImagem = classLoader.getResource(
                    "imagens/" + nomes[i] + ".gif");
            imagens[i] = (new ImageIcon(urlImagem)).getImage();
            botoes[i] = new JButton(nomes[i]);
            TrataEv t = new TrataEv(i);
            botoes[i].addActionListener(t);
            pSul.add(botoes[i]);
        }
        getContentPane().add(painel4, BorderLayout.CENTER);
        getContentPane().add(pSul, BorderLayout.SOUTH);
    }

    class TrataEv implements ActionListener {

        private int indice;

        TrataEv(int indice) {
            this.indice = indice;
        }

        public void actionPerformed(ActionEvent evt) {
            indiceCorrente = indice;
            painel4.repaint();
        }
    }

    class Painel4 extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension d = getSize();
            g.drawImage(imagens[indiceCorrente], 0, 0, d.width, d.height, null);
        }
    }

    public static void main(String[] args) {
        MostrarImagemJPanel jan = new MostrarImagemJPanel("Mostrar Imagem");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(500, 600);
        jan.setVisible(true);
    }
}
