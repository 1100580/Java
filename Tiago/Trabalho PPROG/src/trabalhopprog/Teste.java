/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tiago
 */
public class Teste extends JFrame {

    JButton previous = new JButton("Anterior");
    JButton next = new JButton("Seguinte");
    JButton end = new JButton("Finalizar Teste");
    JPanel center;
    JFrame janela;
    double nota;

    public Teste(String titulo, ArrayPerguntas a) {
        super(titulo);
        this.janela = this;
        Container c = getContentPane();
        Relogio r = new Relogio(this);
        JPanel norte = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        fl.setHgap(10);
        fl.setVgap(10);
        norte.setLayout(fl);
        r.setPreferredSize(new Dimension(100, 100));
        norte.add(r);
        c.add(norte, BorderLayout.NORTH);

        CardLayout cl = new CardLayout();
        center = new JPanel(cl);
        center.setAlignmentX(CENTER_ALIGNMENT);
        center.setAlignmentY(CENTER_ALIGNMENT);
        int cont = 1;
        while (!a.isEmpty()) {
            if (a.get(0) instanceof RespostaUnica) {
                center.add(new PainelUnica((RespostaUnica) a.get(0), cont), Integer.toString(cont));
            } else if (a.get(0) instanceof RespostaMultipla) {
                center.add(new PainelMultipla((RespostaMultipla) a.get(0), cont), Integer.toString(cont));

            } else if (a.get(0) instanceof RespostaExtenso) {
                center.add(new PainelExtenso((RespostaExtenso) a.get(0), cont), Integer.toString(cont));
            }
            cont++;
            a.remove(0);
        }
        c.add(center, BorderLayout.CENTER);

        JPanel down = new JPanel(new FlowLayout());
        previous.setEnabled(false);
        down.add(previous);
        down.add(next);
        down.add(end);

        TrataDeslocamento t = new TrataDeslocamento(center);
        next.addActionListener(t);
        previous.addActionListener(t);
        TrataBotaoEnd tbe = new TrataBotaoEnd(end, this, this);
        end.addActionListener(tbe);

        c.add(down, BorderLayout.SOUTH);
        this.setMinimumSize(new Dimension(800, 600));
    }

    class TrataDeslocamento implements ActionListener {

        final int MAX_POS = 10;
        final int MIN_POS = 1;
        JPanel center;
        int pos = 1;

        TrataDeslocamento(JPanel center) {
            this.center = center;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                CardLayout cl = (CardLayout) (center.getLayout());
                cl.next(center);
                previous.setEnabled(true);
                if (++pos == MAX_POS) {
                    next.setEnabled(false);
                }
            } else {
                CardLayout cl = (CardLayout) (center.getLayout());
                cl.previous(center);
                next.setEnabled(true);
                if (--pos == MIN_POS) {
                    previous.setEnabled(false);
                }
            }
        }
    }

    public void corrigirTeste() {
        nota = 0;
        for (int i = 0; i < 10; i++) {
            if (center.getComponent(i) instanceof PainelUnica) {
                PainelUnica pu = (PainelUnica) center.getComponent(i);
                RespostaUnica r = (RespostaUnica) pu.getResposta();
                JComponent[] v = pu.getV();
                int rbselected = 0;
                int cont = 1;
                for (int j = 1; j < v.length; j = j + 2) {
                    JRadioButton rb = (JRadioButton) v[j];
                    if (rb.isSelected()) {
                        rbselected = cont;
                        break;
                    }
                    cont++;
                }
                int res = r.ValidaResposta(rbselected);
                if (res == 1) {
                    nota = nota + 2;
                } else if (res == -1) {
                    nota = nota - 0.5;
                }
            } else if (center.getComponent(i) instanceof PainelMultipla) {
                PainelMultipla pm = (PainelMultipla) center.getComponent(i);
                RespostaMultipla r = (RespostaMultipla) pm.getResposta();
                JComponent[] v = pm.getV();
                boolean cbselected[] = new boolean[v.length / 2];
                int cont = 0;
                for (int j = 1; j < v.length; j = j + 2) {
                    JCheckBox cb = (JCheckBox) v[j];
                    if (cb.isSelected()) {
                        cbselected[cont] = true;
                    } else {
                        cbselected[cont] = false;
                    }
                    cont++;
                }
                int res = r.ValidaResposta(cbselected);
                if (res == 1) {
                    nota = nota + 2;
                } else if (res == -1) {
                    nota = nota - 0.5;
                }
            } else if (center.getComponent(i) instanceof PainelExtenso) {
                PainelExtenso pe = (PainelExtenso) center.getComponent(i);
                RespostaExtenso r = (RespostaExtenso) pe.getResposta();
                int res = r.ValidaResposta(pe.getResp());
                if (res == 1) {
                    nota = nota + 2;
                } else if (res == -1) {
                    nota = nota - 0.5;
                }
            }

        }
        if (nota < 0) {
            nota = 0;
        }
    }

    public void terminarTeste(boolean tempo) {
        this.corrigirTeste();
        janela.setVisible(false);
        janela.dispose();
        String texto;
        if (tempo) {
            texto = "Fim do Teste! Fim do tempo establecido!";
        } else {
            texto = "Fim do Teste! Parabéns, conseguiu terminar o teste antes do tempo acabar!";
        }
        JanelaResult jr = new JanelaResult("Resultado", nota, texto);
        jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jr.setVisible(true);
        jr.setSize(1000, 700);
    }

    class TrataBotaoEnd implements ActionListener {

        JButton end;
        JFrame janela;
        Teste t;

        TrataBotaoEnd(JButton end, JFrame janela, Teste t) {
            this.end = end;
            this.janela = janela;
            this.t = t;

        }

        public void actionPerformed(ActionEvent e) {
            t.terminarTeste(false);
        }
    }
}
