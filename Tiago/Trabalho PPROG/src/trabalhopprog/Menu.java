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
public class Menu extends JFrame {

    JButton end = new JButton("Gerar Teste");
    JComponent[] arr;
    public static String[] temas = {"Matemática", "História", "Geografia", "Informática", "Ciências"};
    public static int[] npergtema;
    public static String[] temasteste;

    public Menu(String titulo, ArrayPerguntas a) {
        super(titulo);
        Container c = getContentPane();
        JPanel norte = new JPanel(new BorderLayout());
        JLabel tit1 = new JLabel("MENU");
        norte.add(tit1, BorderLayout.NORTH);
        tit1.setHorizontalAlignment(JLabel.CENTER);
        Font letra = new Font("", 1, 20);
        tit1.setFont(letra);
        tit1.setPreferredSize(new Dimension(100, 70));
        JPanel nortecentro = new JPanel(new GridLayout(8, 1));
        JLabel tit2 = new JLabel("      Escolha os temas pretendidos para o teste e introduza o nº de perguntas para cada tema.");
        JLabel tit3 = new JLabel("      Caso seleccione os temas e não introduza o nº de perguntas, esse nº será atribuido automaticamente.");
        JLabel tit4 = new JLabel("      Lembre-se que o total de perguntas tem que ser igual a 10.");
        JLabel tit5 = new JLabel("      Dispõe de 10 minutos para fazer o teste. Atingindo esse tempo o teste finalizar-se-á automaticamente.");
        JLabel tit6 = new JLabel("      Por cada resposta certa soma 2 valores e por cada errada desconta 0.5, sendo o teste para 20 valores.");
        JLabel tit7 = new JLabel("      Se não responder não sofre penalização nem bonificação. Boa Sorte!");
        JLabel vazio = new JLabel();
        tit2.setPreferredSize(new Dimension(300, 28));
        nortecentro.add(tit2);
        nortecentro.add(tit3);
        nortecentro.add(tit4);
        nortecentro.add(tit5);
        nortecentro.add(tit6);
        nortecentro.add(tit7);
        nortecentro.add(vazio);
        norte.add(nortecentro, BorderLayout.CENTER);
        c.add(norte, BorderLayout.NORTH);
        GridLayout g = new GridLayout(5, 3);
        g.setHgap(10);
        g.setVgap(10);

        JPanel center = new JPanel(g);
        arr = new JComponent[15];
        int cont = 0;
        for (int i = 0; i < 15; i = i + 3) {
            arr[i] = new JCheckBox();
            ((JCheckBox) arr[i]).setActionCommand(Integer.toString(i));
            ((JCheckBox) arr[i]).setHorizontalAlignment(SwingConstants.RIGHT);
            arr[i + 1] = new JLabel(temas[cont]);
            arr[i + 2] = new JTextField();
            arr[i + 2].setEnabled(false);
            cont++;
        }
        for (int i = 0; i < arr.length; i++) {
            center.add(arr[i]);
        }
        center.setSize(new Dimension(500, 500));
        JPanel help1 = new JPanel(new FlowLayout());
        TrataCaixasTexto t = new TrataCaixasTexto(arr);
        for (int i = 0; i < arr.length; i = i + 3) {
            JCheckBox cb = (JCheckBox) arr[i];
            cb.addActionListener(t);
        }
        help1.add(center);
        c.add(help1, BorderLayout.CENTER);

        JPanel down = new JPanel(new FlowLayout());
        TrataBotaoEnd tbe = new TrataBotaoEnd(end, this, a);
        end.addActionListener(tbe);
        down.add(end);

        c.add(down, BorderLayout.SOUTH);
        this.setMinimumSize(new Dimension(700, 580));
    }

    class TrataCaixasTexto implements ActionListener {

        JComponent[] arr;

        TrataCaixasTexto(JComponent[] arr) {
            this.arr = arr;
        }

        public void actionPerformed(ActionEvent e) {
            JCheckBox cb = (JCheckBox) e.getSource();
            JTextField tb = (JTextField) arr[Integer.parseInt(cb.getActionCommand()) + 2];
            if (cb.isSelected()) {
                tb.setEnabled(true);
            } else {
                tb.setText("");
                tb.setEnabled(false);
            }
        }
    }

    class TrataBotaoEnd implements ActionListener {

        JButton end;
        JFrame janela;
        ArrayPerguntas a;

        TrataBotaoEnd(JButton end, JFrame janela, ArrayPerguntas a) {
            this.end = end;
            this.janela = janela;
            this.a = a;
        }

        public void actionPerformed(ActionEvent e) {
            int cont = 0;
            int cont1 = 0;
            int cont2 = 0;

            boolean bug = false;
            boolean inseriu = false;
            for (int i = 0; i < arr.length; i = i + 3) {
                if (((JCheckBox) arr[i]).isSelected()) {
                    cont1++;
                }
            }
            if (cont1 > 0) {
                npergtema = new int[cont1];
                temasteste = new String[cont1];
                for (int i = 0; i < arr.length; i = i + 3) {
                    if (((JCheckBox) arr[i]).isSelected()) {
                        temasteste[cont2] = temas[cont];

                        if (((JTextField) arr[i + 2]).getText().equals("")) {
                            npergtema[cont2] = 0;
                        } else {
                            inseriu = true;
                            try {
                                npergtema[cont2] = Integer.parseInt(((JTextField) arr[i + 2]).getText());
                            } catch (Exception ex) {
                                if (bug == false) {
                                    JOptionPane.showMessageDialog(null, "O número de perguntas por tema deve ser do tipo inteiro.");
                                    bug = true;
                                }
                            }
                        }
                        cont2++;
                    }
                    cont++;
                }
                int soma;
                boolean valimp = false;
                if (inseriu) {
                    soma = 0;
                    for (int i = 0; i < npergtema.length; i++) {
                        if (npergtema[i] >= 0 && npergtema[i] <= 10) {
                            soma = soma + npergtema[i];
                        } else {
                            valimp = true;
                        }
                    }
                } else {
                    soma = 10;
                }
                if (soma != 10 && !bug) {
                    JOptionPane.showMessageDialog(null, "O número total de perguntas deve ser igual a 10.");
                    bug = true;
                } else if (valimp == true && !bug) {
                    JOptionPane.showMessageDialog(null, "O número de perguntas por tema deve ser positivo e não maior que 10.");
                    bug = true;
                } else if (!bug) {
                    janela.setVisible(false);
                    janela.dispose();
                    ArrayPerguntas pergteste = a.escolherPerguntasTeste(temasteste, npergtema);
                    Teste t = new Teste("Teste", pergteste);
                    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    t.setVisible(true);
                    t.setSize(1000, 700);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tem que seleccionar pelo menos um tema!");
            }
        }
    }
}

