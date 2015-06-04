/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Relogio extends JPanel {

    private int minutos = 0;
    private int segundos = 0;
    private int raio = 0;
    private static final double DELTA = Math.PI / 6;
    private Timer timer;
    private int segundosTerminar = 00;
    private int minutosTerminar = 5;
    Teste teste;

    public Relogio(Teste teste) {
        this.teste = teste;
        MostradorListener t = new MostradorListener();
        timer = new Timer(1000, t);
        timer.start();
        setSize(300, 300);
    }

    public boolean terminar() {
        if (minutos == minutosTerminar && segundos == segundosTerminar) {
            return true;
        }
        return false;
    }

    public void tick() {
        if (++segundos == 60) {
            segundos = 0;
            if (++minutos == 60) {
                minutos = 0;
            }
        }
    }

    public void desenhaPonteiros(Graphics g) {
        double anguloMinutos = 2 * Math.PI * (minutos - 15) / 60;
        double anguloSegundos = 2 * Math.PI * (segundos - 15) / 60;
        g.drawLine(raio, raio, raio + (int) (raio * 0.9 * Math.cos(anguloMinutos)),
                raio + (int) (raio * 0.8 * Math.sin(anguloMinutos)));
        g.drawLine(raio, raio, raio + (int) (raio * 0.8 * Math.cos(anguloSegundos)),
                raio + (int) (raio * 0.9 * Math.sin(anguloSegundos)));
    }

    public void desenhaMostrador(Graphics g) {
        double angulo;
        for (angulo = 0.0; angulo < 2 * Math.PI; angulo = angulo + DELTA) // desenha marcas no mostrador
        {
            g.drawLine(
                    raio + (int) ((raio - 4) * Math.cos(angulo)),
                    raio + (int) ((raio - 4) * Math.sin(angulo)),
                    raio + (int) (raio * Math.cos(angulo)),
                    raio + (int) (raio * Math.sin(angulo)));

        }
        g.drawOval(0, 0, 2 * raio, 2 * raio);
        g.setColor(Color.blue);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        raio = Math.min(getSize().width, getSize().height) / 2;
        desenhaMostrador(g);
        desenhaPonteiros(g);
    }

    class MostradorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            tick();
            if (terminar()) {
                timer.stop();
                teste.terminarTeste(true);
            }
            repaint();
        }
    }
}




