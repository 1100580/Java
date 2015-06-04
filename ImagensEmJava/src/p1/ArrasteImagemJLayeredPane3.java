package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArrasteImagemJLayeredPane3 extends JFrame {

    private String[] nomes = {"Bird", "Cat", "Dog"};
    private ImageIcon[] imagens;
    private JLabel[] labels;
    private JLayeredPane layeredPane;
    private Integer layerDoLabel;
    private JLabel labelEmMovimento = null;
    // Posicao inicial do componente antes do arraste
    private int xInicial, yInicial;
    // Ajuste da posicao do componente relativamente ao rato
    private int xDif, yDif;
    private boolean quadradoPreto = false;

    public ArrasteImagemJLayeredPane3(String titulo) {
        super(titulo);
        layeredPane = new JLayeredPane();
        // preencher o fundo
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                JPanel p = new JPanel();
                p.setBounds(200 * i, 200 * j, 200, 200);
                if ((i + j) % 2 == 0) {
                    p.setBackground(Color.black);
                }
                layeredPane.add(p, new Integer(0));
            }
        }
        imagens = new ImageIcon[nomes.length];
        labels = new JLabel[nomes.length];

        ClassLoader classLoader = this.getClass().getClassLoader();
        TrataEvMouse t1 = new TrataEvMouse();
        TrataEvMouseMotion t2 = new TrataEvMouseMotion();

        for (int i = 0; i < nomes.length; i++) {
            java.net.URL urlImagem = classLoader.getResource(
                    "imagens/" + nomes[i] + ".gif");
            imagens[i] = new ImageIcon(urlImagem);
            labels[i] = new JLabel(imagens[i]);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.red);
            labels[i].setBounds(30 + 200 * i, 30, 140, 140);
            //labels[i].setBorder(BorderFactory.createLineBorder(Color.blue));
            labels[i].addMouseListener(t1);
            labels[i].addMouseMotionListener(t2);
            layeredPane.add(labels[i], new Integer(2));
        }

        getContentPane().add(layeredPane, BorderLayout.CENTER);
    }

    class TrataEvMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent evt) {
            labelEmMovimento = (JLabel) evt.getSource();
            layerDoLabel = layeredPane.getLayer(evt.getComponent());
            layeredPane.setLayer(evt.getComponent(), JLayeredPane.DRAG_LAYER);
            xDif = evt.getX();
            yDif = evt.getY();
            xInicial = evt.getX() + evt.getComponent().getX() - xDif;
            yInicial = evt.getY() + evt.getComponent().getY() - yDif;
            quadradoPreto = quadradoPreto(xInicial, yInicial);
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            labelEmMovimento = (JLabel) evt.getSource();
            int x = labelEmMovimento.getX() + evt.getX();
            int y = labelEmMovimento.getY() + evt.getY();
            if (quadradoPreto == quadradoPreto(x, y)) {
                int linha = y / 200;
                int coluna = x / 200;
                labelEmMovimento.setBounds(30 + coluna * 200, 30 + linha * 200, 140, 140);
            } else {
                Movimento mov = new Movimento();
                mov.start();
                //labelEmMovimento.setBounds(xInicial, yInicial, 140, 140);
            }
            layeredPane.setLayer(evt.getComponent(), layerDoLabel);
            //labelEmMovimento = null;
        }
    }

    class Movimento extends Thread {

        private int velocidade = 30;

        @Override
        public void run() {
            for (int j = 0; j <= 20; j++) {  // 20 passos para mover cada imagem
                int xx = (int) (((xInicial - labelEmMovimento.getX()) / 20.0) * j);
                int yy = (int) (((yInicial - labelEmMovimento.getY()) / 20.0) * j);
                labelEmMovimento.setBounds(labelEmMovimento.getX() + xx, labelEmMovimento.getY() + yy, 140, 140);
                try {
                    Thread.sleep(velocidade);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class TrataEvMouseMotion extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent evt) {
            if (labelEmMovimento == null) {
                return;
            }
            // Coordenadas do componente ajustadas relativamente ao rato
            labelEmMovimento.setBounds(
                    labelEmMovimento.getX() + evt.getX() - xDif,
                    labelEmMovimento.getY() + evt.getY() - yDif, 140, 140);
        }
    }

    public boolean quadradoPreto(int x, int y) {
        int linha = y / 200;
        int coluna = x / 200;
        if ((linha + coluna) % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrasteImagemJLayeredPane3 jan = new ArrasteImagemJLayeredPane3("Arraste de JLabel");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(620, 645);
        jan.setVisible(true);
    }
}
