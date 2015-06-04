package fisica;

import fisica.GUI;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        GUI g1 = new GUI();
        g1.setResizable(false);
        g1.setUndecorated(true);
        g1.getContentPane();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int windowWidth = 600;
        int windowHeight = 246;
        // set position and size
        g1.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth, windowHeight);
        g1.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
        
        ImagePanel panel = new ImagePanel(new ImageIcon("isep_logo.jpg").getImage());

        g1.getContentPane().add(panel);
        g1.setVisible(true);
        
    }
}
