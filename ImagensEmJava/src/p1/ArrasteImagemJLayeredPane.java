package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArrasteImagemJLayeredPane extends JFrame {
    private String[] nomes = { "Bird","Cat", "Dog" };
    private ImageIcon[] imagens;
    private JLabel[] labels;
    private JLayeredPane layeredPane;
    private Integer layerDoLabel;
    private JLabel labelEmMovimento = null;
    // Ajuste da posicao do componente relativamente ao rato
    private int xDif, yDif;

    public ArrasteImagemJLayeredPane(String titulo) {
        super(titulo);
        layeredPane = new JLayeredPane();
        // preencher o fundo
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                JPanel p  = new JPanel();
                p.setBounds(200*i, 200*j, 200, 200);
                if ((i+j)%2 == 0) p.setBackground(Color.black);
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
                                            "imagens/" + nomes[i] +".gif");
            imagens[i] = new ImageIcon(urlImagem );
            labels[i] = new JLabel(imagens[i]);
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.red);
            labels[i].setBounds(30+200*i, 30, 140, 140);
//              labels[i].setBorder(BorderFactory.createLineBorder(Color.blue));
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
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            labelEmMovimento = null;
            layeredPane.setLayer(evt.getComponent(), layerDoLabel);
        }
    }

    class TrataEvMouseMotion extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent evt) {
            if (labelEmMovimento == null) return;
            // Coordenadas do componente ajustadas relativamente ao rato
            labelEmMovimento.setBounds(
                    labelEmMovimento.getX() + evt.getX() - xDif,
                    labelEmMovimento.getY() + evt.getY() - yDif, 140, 140);
        }
    }

    public static void main(String[] args) {
        ArrasteImagemJLayeredPane jan = new ArrasteImagemJLayeredPane("Arraste de JLabel");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(600, 600);
        jan.setVisible(true);
    }
}
