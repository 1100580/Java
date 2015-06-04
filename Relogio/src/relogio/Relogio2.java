package relogio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class Relogio2 extends JFrame {
    
    public Relogio2(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mostrador mostrador = new Mostrador();
        mostrador.acertaHora();
        add(mostrador);
    }  
    
    class Mostrador extends JPanel {
        private int horas = 0;
        private int minutos = 0;
        private int segundos = 0;
        private int raio = 0;
        private static final double DELTA = Math.PI / 6;
        
        public Mostrador() {
            MostradorListener t = new MostradorListener();
            Timer timer = new Timer(1000, t);
            timer.start();
        }
        
        public void acertaHora() {
            Calendar calendar = Calendar.getInstance();
            horas = calendar.get(Calendar.HOUR_OF_DAY);
            minutos = calendar.get(Calendar.MINUTE);
            segundos = calendar.get(Calendar.SECOND);  
        }
        
        public void desenhaPonteiros(Graphics g) {
            double anguloHoras = 2 * Math.PI * (horas - 3) / 12;
            double anguloMinutos = 2 * Math.PI * (minutos - 15) / 60;
            double anguloSegundos = 2 * Math.PI * (segundos - 15) / 60;
            g.drawLine(raio, raio, raio + (int)(raio*0.7 * Math.cos(anguloHoras)),
                    raio + (int)(raio*0.7 * Math.sin(anguloHoras)));
            g.drawLine(raio, raio, raio + (int)(raio * 0.9 * Math.cos(anguloMinutos)),
                    raio + (int)(raio * 0.9 * Math.sin(anguloMinutos)));
            g.drawLine(raio, raio, raio + (int)(raio * 0.8 * Math.cos(anguloSegundos)),
                    raio + (int)(raio * 0.8 * Math.sin(anguloSegundos)));
        }
        
        public void desenhaMostrador(Graphics g) {
            double angulo;
            for (angulo = 0.0; angulo < 2*Math.PI ; angulo = angulo + DELTA)
                // desenha marcas no mostrador
                g.drawLine(
                        raio + (int)((raio-4) * Math.cos(angulo)),
                        raio + (int)((raio-4) * Math.sin(angulo)),
                        raio + (int)(raio * Math.cos(angulo)),
                        raio + (int)(raio * Math.sin(angulo))
                        );
            g.drawOval(0, 0, 2*raio, 2*raio);
        }
        
	@Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            raio = Math.min(getSize().width,getSize().height)/2;
            desenhaMostrador(g);
            desenhaPonteiros(g);
        }
        
        class MostradorListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                acertaHora();
                repaint();
            }
        }
    }
   
    public static void main(String args[]) {
        Relogio2 apl = new Relogio2("Relógio");
        apl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apl.setSize(300, 300);
        apl.setVisible(true);
    }
}
