package InterfaceGrafica;

import java.io.IOException;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MesaGUI jan = new MesaGUI("Jogo das sequências");
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(810, 430);
        jan.setVisible(true);
    }
}