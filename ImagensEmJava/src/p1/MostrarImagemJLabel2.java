package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarImagemJLabel2 extends JFrame {
    private String[] nomes = { "Bird","Cat", "Dog", "Rabbit", "Pig" };
    private ImageIcon[] imagens;
    private JButton[] botoes;
    private JLabel label;

    public MostrarImagemJLabel2(String titulo) {
        super(titulo);
        JPanel pCentro = new JPanel();
        JPanel pSul = new JPanel();
        imagens = new ImageIcon[nomes.length];
        botoes = new JButton[nomes.length];     
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (int i = 0; i < nomes.length; i++) {
            java.net.URL urlImagem = classLoader.getResource(
                                            "imagens/" + nomes[i] +".gif");
            imagens[i] = new ImageIcon(urlImagem );
            botoes[i] = new JButton(nomes[i]);
            TrataEv t = new TrataEv(i);
            botoes[i].addActionListener(t);
            pSul.add(botoes[i]);
        }
        label = new JLabel(imagens[0]);
        label.setPreferredSize(new Dimension(200,200));
        label.setOpaque(true);
        label.setBackground(Color.red);
        pCentro.add(label);
        getContentPane().add(pCentro, BorderLayout.CENTER);
        getContentPane().add(pSul, BorderLayout.SOUTH);
    }

    class TrataEv implements ActionListener {
        private int indice;

        TrataEv(int indice) {
            this.indice = indice;
        }
        public void actionPerformed(ActionEvent evt) {
            label.setIcon(imagens[indice]);
        }
    }

    public static void main(String[] args) {
        MostrarImagemJLabel2 jan = new MostrarImagemJLabel2("Mostrar Imagem");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(500, 300);
        jan.setVisible(true);
    }
}
