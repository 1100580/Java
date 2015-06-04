import javax.swing.*;

public class Jogo {
    
    public Jogo() {
    }

    public static void main(String[] args) {
        Adivinha a = new Adivinha();
        InterfaceGrafico jan = new InterfaceGrafico(a);
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jan.setSize(600, 350);
        jan.setVisible(true); 
    }
    
}
