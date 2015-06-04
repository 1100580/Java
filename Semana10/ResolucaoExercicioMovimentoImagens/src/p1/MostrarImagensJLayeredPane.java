package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MostrarImagensJLayeredPane extends JFrame {
    private String[] nomes = { "Bird","Cat", "Dog", "Rabbit", "Pig" };
    private ImageIcon[] imagens;
    private JButton adicionar, remover;
    private JLabel[] labels;
    private JLayeredPane layeredPane;
    private int indice = 0;

    public MostrarImagensJLayeredPane(String titulo) {
        super(titulo);
        JPanel pSul = new JPanel();
        layeredPane = new JLayeredPane();
        imagens = new ImageIcon[nomes.length];
        labels = new JLabel[nomes.length];
        adicionar = new JButton("Adicionar");
        remover = new JButton("Remover");
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (int i = 0; i < nomes.length; i++) {
            java.net.URL urlImagem = classLoader.getResource(
                                            "imagens/" + nomes[i] +".gif");
            imagens[i] = new ImageIcon(urlImagem );
            labels[i] = new JLabel(imagens[i]);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.red);
        }
        TrataEv t = new TrataEv();
        adicionar.addActionListener(t);
        remover.addActionListener(t);
        pSul.add(adicionar);
        pSul.add(remover);
        getContentPane().add(layeredPane, BorderLayout.CENTER);
        getContentPane().add(pSul, BorderLayout.SOUTH);
    }

    class TrataEv implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == adicionar) {
                if (indice < nomes.length) {
                    labels[indice].setBounds(100, indice * 70, 140, 140);
                    layeredPane.add(labels[indice], 0);
                    indice++;
                }
            } else {
                if (indice > 0) {
                    indice--;
                    labels[indice].setBounds(-100, -100, 10, 10);
                }
            }
        }
    }

    public static void main(String[] args) {
        MostrarImagensJLayeredPane jan =
                new MostrarImagensJLayeredPane("Mostrar Imagem");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(500, 600);
        jan.setVisible(true);
    }
}
