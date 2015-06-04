package PonG;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Janela extends JFrame implements Runnable {

    Container c = getContentPane();
    JLayeredPane layeredPane = new JLayeredPane();
    JPanel player1 = new JPanel();
    JPanel player2 = new JPanel();
    JPanel bola = new JPanel();
    Campo campo = new Campo();
    
    public Janela() {
        super("POnG!");
        c.setBackground(Color.DARK_GRAY);

        player1.setBackground(Color.white);
        player1.setBounds(100, 125, 7, 50);
        player1.setFocusable(true);
        player1.setVisible(true);

        player2.setBackground(Color.white);
        player2.setBounds(400, 125, 7, 50);
        player2.setVisible(true);

        c.add(player1);
        c.add(player2);
        c.add(campo);
        atribuiKList();
        
        bola.setLocation(100, 100);
        bola.setBackground(Color.red);
        c.add(bola);
        
        Thread t = new Thread(this);
        t.start();// behaviour of thread controlled by run method
    }

    private void atribuiKList() {
        player1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = player1.getX();
                int y = player1.getY();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_Q:
                        player1.setBounds(x, y - 5, player1.getWidth(), player1.getHeight());
                        break;
                    case KeyEvent.VK_A:
                        player1.setBounds(x, y + 5, player1.getWidth(), player1.getHeight());
                        break;
                }
                player1.validate();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void run() {
        
        for (;;) {
            bola.setBounds(bola.getX() + 1, bola.getY() + 1, 10,10);
            try {Thread.sleep(10);} catch (InterruptedException ex) {}
            bola.validate();
        }
    }
}

class Campo extends JComponent {

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(50, 50, 400, 200);

        //line thickness?
        //baliza esquerda
        g.drawLine(51, 100, 51, 200);
        g.drawLine(52, 100, 52, 200);

        //baliza direita
        g.drawLine(449, 100, 449, 200);
        g.drawLine(448, 100, 448, 200);
    }
}
