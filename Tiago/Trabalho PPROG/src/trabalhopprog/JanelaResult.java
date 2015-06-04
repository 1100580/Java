/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Tiago
 */
public class JanelaResult extends JFrame {

    public JanelaResult(String titulo, double nota, String texto) {
        super(titulo);
        Container c = getContentPane();
        GridLayout gl = new GridLayout(3, 1);
        JPanel jp = new JPanel(gl);
        jp.setAlignmentX(CENTER_ALIGNMENT);
        jp.setAlignmentY(CENTER_ALIGNMENT);
        JPanel vazio1 = new JPanel();
        JPanel vazio2 = new JPanel();
        JPanel center = new JPanel(new GridLayout(2, 1));
        JLabel cabecalho = new JLabel(texto);
        cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(cabecalho);
        JLabel result = new JLabel("Pontuação final: " + Double.toString(nota) + " valores.");
        result.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(result);
        jp.add(vazio1);
        jp.add(center);
        jp.add(vazio2);
        c.add(jp);
        this.setMinimumSize(new Dimension(500, 350));
    }
}
