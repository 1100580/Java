/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author i090674
 */
public class PainelExtenso extends JPanel {

    JTextField resp;
    RespostaExtenso r;

    public PainelExtenso(RespostaExtenso r, int n) {
        super();
        this.r = r;
        GridLayout gl = new GridLayout(4, 1);
        gl.setHgap(10);
        gl.setVgap(10);
        JPanel painel = new JPanel(gl);
        JLabel vazio = new JLabel();
        JLabel titulo = new JLabel("Pergunta nº " + n + ":");
        JLabel perg = new JLabel(r.getPergunta());
        resp = new JTextField();
        painel.add(vazio);
        painel.add(titulo);
        painel.add(perg);
        painel.add(resp);
        this.add(painel);
    }

    public RespostaExtenso getResposta() {
        return this.r;
    }

    public String getResp() {
        return this.resp.getText();
    }
}
