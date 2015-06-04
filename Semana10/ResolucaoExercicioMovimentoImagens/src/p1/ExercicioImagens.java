package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExercicioImagens extends JFrame {

    private String[] nomes = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    private ImageIcon[] imagens;
    private JButton adicionar, remover;
    private BotaoComImagem[] botoes;
    private JLayeredPane layeredPane;
    private int indice = 0;

    public ExercicioImagens(String titulo) {
        super(titulo);
        JPanel pSul = new JPanel();
        layeredPane = new JLayeredPane();
        imagens = new ImageIcon[nomes.length];
        botoes = new BotaoComImagem[nomes.length];
        adicionar = new JButton("Adicionar");
        remover = new JButton("Remover");
        ClassLoader classLoader = this.getClass().getClassLoader();
        TrataEvBotao trataEvBotao = new TrataEvBotao();
        for (int i = 0; i < nomes.length; i++) {
            java.net.URL urlImagem = classLoader.getResource(
                    "imagens/" + nomes[i] + ".gif");
            imagens[i] = new ImageIcon(urlImagem);
            botoes[i] = new BotaoComImagem(imagens[i], i);
            botoes[i].setColocadoNaPilhaDireita(false);
            botoes[i].setOpaque(true);
            botoes[i].setBackground(Color.red);
            botoes[i].addActionListener(trataEvBotao);
        }
        TrataEv t = new TrataEv();
        adicionar.addActionListener(t);
        remover.addActionListener(t);
        pSul.add(adicionar);
        pSul.add(remover);
        getContentPane().add(layeredPane, BorderLayout.CENTER);
        getContentPane().add(pSul, BorderLayout.SOUTH);
    }

    class BotaoComImagem extends JButton {

        private boolean colocadoNaPilhaDireita = false;
        private int indice;

        public BotaoComImagem(ImageIcon icon, int indice) {
            super(icon);
            this.indice = indice;
        }

        public void setColocadoNaPilhaDireita(boolean b) {
            colocadoNaPilhaDireita = b;
        }

        public boolean getColocadoNaPilhaDireita() {
            return colocadoNaPilhaDireita;
        }

        public int getIndice() {
            return indice;
        }
    }

    class TrataEv implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == adicionar) {
                if (indice < nomes.length) {
                    botoes[indice].setBounds(100, indice * 70, 140, 140);
                    layeredPane.add(botoes[indice], 0);
                    indice++;
                }
            } else {
                if (indice > 0) {
                    indice--;
                    botoes[indice].setBounds(-100, -100, 10, 10);
                }
            }
        }
    }

    class TrataEvBotao implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            BotaoComImagem botao = null;
            if (evt.getSource() instanceof BotaoComImagem) {
                botao = (BotaoComImagem) evt.getSource();
            }
            int indice = botao.getIndice();
            if (botao.getColocadoNaPilhaDireita()) {
                botao.setBounds(100, indice * 70, 140, 140);
                botao.setColocadoNaPilhaDireita(false);
            } else {
                botao.setBounds(300, 70, 140, 140);
                botao.setColocadoNaPilhaDireita(true);
            }
        }
    }

    public static void main(String[] args) {
        ExercicioImagens jan = new ExercicioImagens("Exercicio Imagens");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(500, 600);
        jan.setVisible(true);
    }
}
