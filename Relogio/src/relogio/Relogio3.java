package relogio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Calendar;

public class Relogio3 extends JFrame {
    
    public Relogio3(String titulo) {
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
        
        public void desenhaPonteiros(Graphics2D g2) {
            double anguloHoras = 2 * Math.PI * (horas+minutos/60.0 - 3) / 12;
            double anguloMinutos = 2 * Math.PI * (minutos - 15) / 60;
            double anguloSegundos = 2 * Math.PI * (segundos - 15) / 60;
            Shape ponteiroHoras = new Line2D.Double(raio, raio,
                    raio + raio*0.7 * Math.cos(anguloHoras),
                    raio + raio*0.7 * Math.sin(anguloHoras));
            Shape ponteiroMinutos = new Line2D.Double(raio, raio,
                    raio + raio * 0.9 * Math.cos(anguloMinutos),
                    raio + raio * 0.9 * Math.sin(anguloMinutos));
            Shape ponteiroSegundos = new Line2D.Double(raio, raio,
                    raio + raio * 0.8 * Math.cos(anguloSegundos),
                    raio + raio * 0.8 * Math.sin(anguloSegundos));
            Stroke s = g2.getStroke();
            g2.setStroke(new BasicStroke(4));
            g2.draw(ponteiroHoras);
            g2.setStroke(new BasicStroke(2));
            g2.draw(ponteiroMinutos);
            g2.setStroke(s);
            g2.setPaint(Color.blue);
            g2.draw(ponteiroSegundos);  
        }
        
        public void desenhaMostrador(Graphics2D g2) {
            double angulo;
            for (angulo = 0.0; angulo < 2*Math.PI ; angulo = angulo + DELTA) {
                // desenha marcas no mostrador
                Shape marca = new Line2D.Double(
                        raio + (raio-4) * Math.cos(angulo),
                        raio + (raio-4) * Math.sin(angulo),
                        raio + raio * Math.cos(angulo),
                        raio + raio * Math.sin(angulo)
                        );
                g2.draw(marca);
            }
            Shape circunferencia = new Ellipse2D.Double(0, 0, 2*raio, 2*raio);
            g2.draw(circunferencia);
        }
        
	@Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            raio = Math.min(getSize().width,getSize().height)/2;
            desenhaMostrador(g2);
            desenhaPonteiros(g2);
        }
        
        class MostradorListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                acertaHora();
                repaint();
            }
        }         
    }
 
     public static void main(String args[]) {
        Relogio3 apl = new Relogio3("Relógio");
        apl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apl.setSize(300, 300);
        apl.setVisible(true);
    }	
}
