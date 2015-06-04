/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author i090674
 */
public class PainelUnica extends JPanel {

    JComponent v[];
    RespostaUnica r;

    public PainelUnica(RespostaUnica r, int n) {
        super();
        this.r = r;
        GridLayout gl = new GridLayout(2, 1);
        JPanel painel = new JPanel(gl);
        GridLayout gl1 = new GridLayout(5, 1);
        gl1.setHgap(10);
        gl1.setVgap(10);
        JPanel painel1 = new JPanel(gl1);
        JPanel vazio1 = new JPanel();
        JLabel titulo = new JLabel("Pergunta nº " + n + ":");
        JLabel perg = new JLabel(r.getPergunta());
        JLabel help = new JLabel("Indique a resposta correcta.");
        JPanel vazio2 = new JPanel();
        v = new JComponent[r.getRespostas().length * 2];
        int cont = 0;
        for (int i = 0; i < v.length; i = i + 2) {
            v[i] = new JLabel(r.getRespostas()[cont]);
            v[i + 1] = new JRadioButton();
            cont++;
        }
        TrataRadioButtons trb = new TrataRadioButtons();
        for (int i = 1; i < v.length; i = i + 2) {
            JRadioButton jb = (JRadioButton) v[i];
            jb.addActionListener(trb);
        }
        painel1.add(vazio1);
        painel1.add(titulo);
        painel1.add(perg);
        painel1.add(help);
        painel1.add(vazio2);
        GridLayout gl2 = new GridLayout(r.getNumeroRespostas(), 2);
        gl2.setHgap(10);
        gl2.setVgap(10);
        JPanel painel2 = new JPanel(gl2);
        for (int i = 0; i < v.length; i++) {
            painel2.add(v[i]);
        }
        painel.add(painel1);
        painel.add(painel2);
        this.add(painel);
    }

    public RespostaUnica getResposta() {
        return this.r;
    }

    public JComponent[] getV() {
        return this.v;
    }

    class TrataRadioButtons implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JRadioButton jb = (JRadioButton) e.getSource();
            if (!jb.isSelected()) {
                jb.setSelected(false);
            } else {
                for (int i = 1; i < v.length; i = i + 2) {
                    JRadioButton jb1 = (JRadioButton) v[i];
                    jb1.setSelected(false);
                }
                jb.setSelected(true);
            }
        }
    }
}
