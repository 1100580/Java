import ClassesEsqueleto.BaseDados;
import ClassesEsqueleto.BaseDadosCurso;
import GUI.GUI;
import Motor.TrataEstatistica;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

/**
 * Esta é classe que contém o método main.
 * @author Grupo 27
 */
public class Main {

    /**
     * Este é o método main no qual são criados os objectos sobre
     * os quais queremos trabalhar, neste caso, a estatística e a janela de
     * interface gráfica.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        GUI g1 = new GUI();
        g1.setResizable(false);
        g1.setUndecorated(true);
        g1.getContentPane();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int windowWidth = 610;
        int windowHeight = 500;
        // set position and size
        g1.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth, windowHeight);
        g1.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
        g1.setVisible(true);
    }
}