package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelComImagem extends JFrame {

    public LabelComImagem(String titulo) {
        super(titulo);
        ClassLoader classLoader = this.getClass().getClassLoader();
        java.net.URL urlImagem   = classLoader.getResource("imagens/Bird.gif");
        ImageIcon imagem1 = new ImageIcon(urlImagem );
        JLabel label = new JLabel(imagem1); 
        label.setOpaque(true);
        label.setBackground(Color.blue);
        getContentPane().add(label, BorderLayout.CENTER);
    }
	
    public static void main(String s[]) {
         JFrame frame = new LabelComImagem("Imagem em Java");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 200);
         frame.setVisible(true);
    }
}
