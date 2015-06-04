package InterfaceGrafica;

import library.Jogo;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import library.Recorde;

public class MesaGUI extends JFrame {

    //componentes gráficos
    JButton deck;
    JPanel pDeck = new JPanel();
    JPanel cartaCima1 = new JPanel();
    JPanel cartaCima2 = new JPanel();
    JPanel cartaCima3 = new JPanel();
    JPanel cartaBaixo1 = new JPanel();
    JPanel cartaBaixo2 = new JPanel();
    JPanel cartaBaixo3 = new JPanel();
    JPanel cartaVirCima = new JPanel();
    JLabel proxCarta1 = new JLabel();
    JLabel proxCarta2 = new JLabel();
    JLabel proxCarta3 = new JLabel();
    static JLabel tempoLabel = new JLabel();
    int layer;
    Container c = getContentPane();
    JLayeredPane layeredPane = new JLayeredPane();
    //Objectos instanciados
    Jogo j1;
    Recorde r1;
    Relogio tempo = new Relogio(1000);
    TrataEvMouse t1 = new TrataEvMouse();

    public MesaGUI(String titulo) throws IOException, ClassNotFoundException {
        super(titulo);

        j1 = new Jogo();


        Object[] opSimNao = {"Sim", "Não"};
        if (JOptionPane.showOptionDialog(MesaGUI.this, "Deseja carregar o último jogo gravado?", "Carregar jogo?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
            try {
                j1 = j1.carregarJogo();
            } catch (Exception e) {
            }
        }
        try {
            r1 = r1.carregaRecorde();
        } catch (NullPointerException npe) {
        }


        criaMenus();
        criaLabels();
        actualizarLabels();

        tempo.start();

        layeredPane.add(cartaCima1);
        layeredPane.add(cartaCima2);
        layeredPane.add(cartaCima3);
        layeredPane.add(cartaBaixo1);
        layeredPane.add(cartaBaixo2);
        layeredPane.add(cartaBaixo3);
        layeredPane.add(proxCarta1);
        layeredPane.add(proxCarta2);
        layeredPane.add(proxCarta3);
        layeredPane.add(cartaVirCima);
        layeredPane.add(tempoLabel);

        c.add(pDeck, BorderLayout.WEST);
        c.add(layeredPane, BorderLayout.CENTER);

        pack();
        setMinimumSize(new Dimension(810, 430));
    }

    public ImageIcon setImage(String url) {
        ClassLoader loaderClass = this.getClass().getClassLoader();
        java.net.URL urlImage = loaderClass.getResource("imagens/" + url + ".png");
        ImageIcon image = new ImageIcon(urlImage);
        return image;
    }

    private void criaMenus() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        JMenuItem menuItem;

        menu = new JMenu("Jogo");
        menu.setMnemonic(KeyEvent.VK_J);
        menuBar.add(menu);

        menuItem = new JMenuItem("Novo Jogo", KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menu.add(menuItem);
        menu.addSeparator();

        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                j1 = new Jogo();
                actualizarLabels();
            }
        });

        menuItem = new JMenuItem("Sair", KeyEvent.VK_S);
        menu.add(menuItem);

        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tempo.suspend();
                Object[] opSimNao = {"Sim", "Não"};
                if (JOptionPane.showOptionDialog(MesaGUI.this, "Deseja fechar a aplicação?\n"
                        + "NOTA: Se desejar gravar antes de sair, clique Não e use o menu Guardar/Carregar.", "A fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
                    MesaGUI.this.dispose();
                } else {
                    tempo.resume();
                }
            }
        });

        menu = new JMenu("Recordes");
        menu.setMnemonic(KeyEvent.VK_R);
        menuBar.add(menu);

        menuItem = new JMenuItem("Ver o recordista", KeyEvent.VK_V);
        menu.add(menuItem);

        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(MesaGUI.this, r1.toString());
                } catch (NullPointerException npe3) {
                    JOptionPane.showMessageDialog(MesaGUI.this, "Não há ainda um recordista");
                }
            }
        });

        menu = new JMenu("Guardar/Carregar");
        menu.setMnemonic(KeyEvent.VK_I);
        menuBar.add(menu);
        menuItem = new JMenuItem("Guardar jogo", KeyEvent.VK_E);
        menu.add(menuItem);

        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    j1.gravarJogo();
                } catch (IOException ex) {
                    Logger.getLogger(MesaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        menuItem = new JMenuItem("Carregar jogo", KeyEvent.VK_F);
        menu.add(menuItem);

        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    j1 = j1.carregarJogo();
                    actualizarLabels();
                } catch (Exception ex) {
                    Logger.getLogger(MesaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        menu = new JMenu("Acerca");
        menu.setMnemonic(KeyEvent.VK_R);
        menuBar.add(menu);

        menuItem = new JMenuItem("Regras", KeyEvent.VK_A);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MesaGUI.this, "Regras do jogo:\n"
                        + "\n"
                        + "-No início do jogo, são removidos do monte de cartões 3\n"
                        + "cartões de qualquer cor, com os números 1, 2 e 3, e dispostos\n"
                        + "para início das sequências.\n"
                        + "O jogador deve então clicar no baralho para retirar uma carta\n"
                        + "Pode mover a carta que retirou ou as das pilhas de baixo com \n"
                        + "2 cliques (um na carta de inicio outro na de destino\n"
                        + "para uma das pilhas em cima se a carta for a próxima\n"
                        + "da sequência ou para uma das pilhas de baixo(auxiliares).\n"
                        + "\n"
                        + ""
                        + "-A sequência iniciada pelo cartão com o número 1 deve ser \n"
                        + "continuada com cartões de qualquer cor, mas com números em \n"
                        + "sequência, até atingir um cartão com o número 7. A sequência \n"
                        + "será 1 – 2 – 3 – 4 – 5 – 6 – 7.\n"
                        + "O mesmo deve ser feito para as outras duas sequências, mas neste\n"
                        + "caso as sequências são de 2 em 2 (2 – 4 – 6 – 1 – 3 – 5 – 7)\n"
                        + " e 3 em 3 (3 – 6 – 2 – 5 – 1 – 4 – 7) respectivamente.\n"
                        + "\n"
                        + "-O jogador vence o jogo se consegue colocar todos os cartões \n"
                        + "completando todas as sequências, ou perde se atinge uma situação\n"
                        + " em que não é possível efectuar qualquer jogada.\n"
                        + "\n"
                        + "BOA SORTE!");
            }
        });

        menuItem = new JMenuItem("Acerca", KeyEvent.VK_A);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MesaGUI.this, "Programa escrito em Java como trabalho de grupo da disciplina PPROG \n"
                        + "1º ano - 2º Semestre. 2010-2011. ISEP.\n"
                        + "Fernando Bessa\n"
                        + "Bruno Tomé");
            }
        });
        setJMenuBar(menuBar);
    }

    private void criaLabels() {

        deck = new JButton();
        deck.setBackground(Color.LIGHT_GRAY);
        deck.add(new JLabel(setImage("costas")));
        deck.setBorder(null);
        deck.addActionListener(new BotaoListener());
        pDeck.add(deck);
        pDeck.setLayout(new FlowLayout());

        cartaVirCima.setBounds(0, 0, 120, 120);
        cartaVirCima.setBackground(Color.LIGHT_GRAY);
        cartaVirCima.add(new JLabel(setImage("noMoreCards")));
        cartaVirCima.addMouseListener(t1);

        cartaCima1.setBounds(140, 0, 120, 120);
        cartaCima1.setBackground(Color.LIGHT_GRAY);
        cartaCima1.add(new JLabel(setImage(j1.getCartaEmArray(1).toString())));
        cartaCima1.addMouseListener(t1);

        cartaCima2.setBounds(280, 0, 120, 120);
        cartaCima2.setBackground(Color.LIGHT_GRAY);
        cartaCima2.add(new JLabel(setImage(j1.getCartaEmArray(2).toString())));
        cartaCima2.addMouseListener(t1);

        cartaCima3.setBounds(420, 0, 120, 120);
        cartaCima3.setBackground(Color.LIGHT_GRAY);
        cartaCima3.add(new JLabel(setImage(j1.getCartaEmArray(3).toString())));
        cartaCima3.addMouseListener(t1);


        cartaBaixo1.setBounds(140, 140, 120, 210);
        cartaBaixo1.setBackground(Color.LIGHT_GRAY);
        cartaBaixo1.add(new JLabel(setImage("empty")));
        cartaBaixo1.addMouseListener(t1);


        cartaBaixo2.setBounds(280, 140, 120, 210);
        cartaBaixo2.setBackground(Color.LIGHT_GRAY);
        cartaBaixo2.add(new JLabel(setImage("empty")));
        cartaBaixo2.addMouseListener(t1);

        cartaBaixo3.setBounds(420, 140, 120, 210);
        cartaBaixo3.setBackground(Color.LIGHT_GRAY);
        cartaBaixo3.add(new JLabel(setImage("empty")));
        cartaBaixo3.addMouseListener(t1);

        proxCarta1.setText("A próxima carta é: " + j1.getProxCarta(1));
        proxCarta1.setBounds(140, 120, 140, 20);
        proxCarta2.setText("A próxima carta é: " + j1.getProxCarta(2));
        proxCarta2.setBounds(280, 120, 140, 20);
        proxCarta3.setText("A próxima carta é: " + j1.getProxCarta(3));
        proxCarta3.setBounds(420, 120, 140, 20);

        tempoLabel.setBounds(560, 0, 300, 15);
    }

    public void actualizarLabels() {
        cartaVirCima.removeAll();
        cartaCima1.removeAll();
        cartaCima2.removeAll();
        cartaCima3.removeAll();
        cartaBaixo1.removeAll();
        cartaBaixo2.removeAll();
        cartaBaixo3.removeAll();

        try {
            cartaVirCima.add(new JLabel(setImage(j1.getCartaEmArray(0).toString())));
        } catch (Exception exc) {
            cartaVirCima.add(new JLabel(setImage("noMoreCards")));
        }

        cartaCima1.add(new JLabel(setImage(j1.getCartaEmArray(1).toString())));
        cartaCima2.add(new JLabel(setImage(j1.getCartaEmArray(2).toString())));
        cartaCima3.add(new JLabel(setImage(j1.getCartaEmArray(3).toString())));

        try {
            if (j1.getPilha(4).isEmpty()) {
                cartaBaixo1.add(new JLabel(setImage("noMoreCards")));
            } else {
                for (int i = j1.getPilha(4).size() - 1; i > -1; i--) {
                    JLabel label = new JLabel(setImage(j1.getTodasCartasEmArray(4, i).toString()));
                    label.setBounds(0, 140 * (i) - 120, 120, 120);
                    label.validate();
                    cartaBaixo1.add(label);
                }
                cartaBaixo1.repaint();
            }
        } catch (Exception exc) {
            cartaBaixo1.add(new JLabel(setImage("noMoreCards")));
        }

        try {
            if (j1.getPilha(5).isEmpty()) {
                cartaBaixo2.add(new JLabel(setImage("noMoreCards")));
            } else {
                for (int i = j1.getPilha(5).size() - 1; i > -1; i--) {
                    JLabel label = new JLabel(setImage(j1.getTodasCartasEmArray(5, i).toString()));
                    label.setBounds(0, 140 + (10 * i), 120, 120);
                    label.validate();
                    cartaBaixo2.add(label);
                }
                cartaBaixo2.repaint();
            }
        } catch (Exception exc) {
            cartaBaixo2.add(new JLabel(setImage("noMoreCards")));
        }

        try {
            if (j1.getPilha(6).isEmpty()) {
                cartaBaixo3.add(new JLabel(setImage("noMoreCards")));
            } else {
                for (int i = j1.getPilha(6).size() - 1; i > -1; i--) {
                    JLabel label = new JLabel(setImage(j1.getTodasCartasEmArray(6, i).toString()));
                    label.setBounds(0, 140 * (i) - 120, 120, 120);
                    label.validate();
                    cartaBaixo3.add(label);
                }
                cartaBaixo3.repaint();
            }
        } catch (Exception exc) {
            cartaBaixo3.add(new JLabel(setImage("noMoreCards")));
        }

        cartaVirCima.validate();
        cartaCima1.validate();
        cartaCima2.validate();
        cartaCima3.validate();
        cartaBaixo1.validate();
        cartaBaixo2.validate();
        cartaBaixo3.validate();

        if (j1.getProxCarta(1) != 100) {
            proxCarta1.setText("A próxima carta é: " + j1.getProxCarta(1));
        } else {
            proxCarta1.setText("A pilha está completa.");
        }
        if (j1.getProxCarta(2) != 100) {
            proxCarta2.setText("A próxima carta é: " + j1.getProxCarta(2));
        } else {
            proxCarta2.setText("A pilha está completa.");
        }
        if (j1.getProxCarta(3) != 100) {
            proxCarta3.setText("A próxima carta é: " + j1.getProxCarta(3));
        } else {
            proxCarta3.setText("A pilha está completa.");
        }
    }

    class BotaoListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                if (j1.getPilha(0).isEmpty()) {
                    j1.deckParaCartaVirCima();
                }
                actualizarLabels();
                layeredPane.add(cartaVirCima, new Integer(++layer));
            } catch (Exception exc) {
                if (j1.getPilha(0).isEmpty() && j1.getPilha(4).isEmpty() && j1.getPilha(5).isEmpty() && j1.getPilha(6).isEmpty()) {
                    Object[] opSimNao = {"Sim", "Não"};
                    if (JOptionPane.showOptionDialog(MesaGUI.this, "Perdeu...que pena, boa sorte para a próxima. Deseja sair?", "Perdeu.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
                        MesaGUI.this.dispose();
                    }
                }
            }
        }
    }

    class TrataEvMouse extends MouseAdapter {

        private int pilhaI;
        private int pilhaF;
        private int mouseClicks;

        @Override
        public void mousePressed(MouseEvent evt) {
            mouseClicks++;
            if (mouseClicks == 1) {
                if (evt.getComponent().getY() == 0) {
                    pilhaI = (evt.getComponent().getX() / 120);
                } else if (evt.getComponent().getY() == 140) {
                    pilhaI = (evt.getComponent().getX() / 120) + 3;
                }
            } else if (mouseClicks == 2) {
                if (evt.getComponent().getY() == 0) {
                    pilhaF = (evt.getComponent().getX() / 120);
                } else if (evt.getComponent().getY() == 140) {
                    pilhaF = (evt.getComponent().getX() / 120) + 3;
                }
                mouseClicks = 0;
                if ((pilhaI >= 0 && pilhaI <= 6) && (pilhaF >= 1 && pilhaF <= 6)) {
                    j1.moverCarta(pilhaI, pilhaF);
                }
            }
            actualizarLabels();
            if (j1.checkFim() == true) {
                Object[] opSimNao = {"Sim", "Não"};
                try {
                    if (r1.checkSeNovoRecorde()) {
                        String nome = JOptionPane.showInputDialog("Novo Recorde! qual o nome que pretende utilizar?");
                        r1.actualizaRecordista(nome);
                    }
                } catch (Exception ex) {
                }
                if (JOptionPane.showOptionDialog(MesaGUI.this, "Parabéns! Ganhou, deseja sair do jogo?",
                        "Vencedor!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
                    MesaGUI.this.dispose();
                }
            }
        }
    }
}
