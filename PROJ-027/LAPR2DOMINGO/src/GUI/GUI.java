package GUI;

import ClassesEsqueleto.BaseDados;
import ClassesEsqueleto.BaseDadosCurso;
import ClassesEsqueleto.UC;
import Motor.ArrayL;
import Motor.TrataEstatistica;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Esta é classe que contém a camada gráfica do projecto derivada da classe JFrame
 * @author Grupo 27
 */
public class GUI extends JFrame implements Serializable {

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel(new BorderLayout());
    Container c = getContentPane();
    JTextField txtSigla, txtNome, txtID, txtAno, txtEpoca;
    JButton butCriar, butCancelar, botaoSelCur, botaoSelUC, butEscolherEst, botaoApaCur, botaoUCEpocas, botaoTrocaTrue, botaoTrocaFalse;
    DefaultListModel listModel;
    JList list;
    JLayeredPane layeredPane = new JLayeredPane();
    BaseDados dados;
    BaseDadosCurso cursoCorrente;
    TrataEstatistica t1 = new TrataEstatistica();
    UC ucCarrEpocaMan;
    int trocaBoo;
    JCheckBox est1, est2, est3;

    /**
     * Class constructor
     */
    public GUI() throws Exception {
        super("Teste do Botão");
        
        JMenuBar j1 = new JMenuBar();
        
        JMenu m1 = new JMenu("Bugs");
        
        JMenuItem i1 = new JMenuItem("Ler");
        JMenuItem i2 = new JMenuItem("Guardar");
        JMenuItem i3 = new JMenuItem("Sair");
        
        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        
        j1.add(m1);
        setJMenuBar(j1);

    }
    /**
     * Este método cria a janela de interface gráfica e os respectivos componentes gráficos
     */
    private void criaMenus() {

        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        JMenuItem menuItem;

        menu = new JMenu("Programa");
        menuBar.add(menu);
        menuItem = new JMenuItem("Escolher Curso", 'E');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('E', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    p2.removeAll();
                    escolherCurso();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Gravar dados", 'A');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dados.gravaBaseDados();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Carregar dados", 'A');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    try {
                        dados = dados.carregaBaseDados();
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Reset base de dados", 'A');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opSimNao = {"Sim", "NÃ£o"};
                if (JOptionPane.showOptionDialog(GUI.this, "Tem a certeza que pretende dar reset à base de dados?\n"
                        + "Esta opção é irreversível!", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
                    dados.resetCursos();
                    try {
                        dados.gravaBaseDados();
                    } catch (IOException ex) {
                    }
                }
            }
        });
        menu.add(menuItem);


        menu.addSeparator();
        menuItem = new JMenuItem("Sair", 'S');
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    fechar();
                } catch (IOException ex) {
                }
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Pautas");
        menuBar.add(menu);
        menuItem = new JMenuItem("Carregar pautas existentes");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    cursoCorrente.carregaAlunos();
                    cursoCorrente.carregaUCSeEpocas();
                    cursoCorrente.carregaPautas();
                } catch (Exception ex) {
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Carregar pauta unica");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    escolherPautaCarregar();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Criar");
        menuBar.add(menu);
        menuItem = new JMenuItem("Curso");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    p2.removeAll();
                    criaCurso();
                } catch (Exception ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Actualizar");
        menuBar.add(menu);
        menuItem = new JMenuItem("Epoca");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    p2.removeAll();
                    actualizarEpocas();
                } catch (Exception ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Apagar");
        menuBar.add(menu);
        menuItem = new JMenuItem("Curso");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    p2.removeAll();
                    removeCurso();
                } catch (Exception ex) {
                }
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Estatisticas");
        menuBar.add(menu);
        menuItem = new JMenuItem("Amostra");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    t1.adicionaResCadeiras(cursoCorrente);
                    t1.trataAmostra(cursoCorrente);
                    JOptionPane.showMessageDialog(GUI.this, "Ficheiro guardado na pasta do projecto/src/estatisticas");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Resultados das UC");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    t1.adicionaResCadeiras(cursoCorrente);
                    t1.trataResUcs(cursoCorrente);
                    JOptionPane.showMessageDialog(GUI.this, "Ficheiro guardado na pasta do projecto/src/estatisticas");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Resultados dos alunos");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    t1.adicionaResCadeiras(cursoCorrente);
                    t1.trataResAlunos(cursoCorrente);
                    JOptionPane.showMessageDialog(GUI.this, "Ficheiro guardado na pasta do projecto/src/estatisticas");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        menu.addSeparator();
        menuItem = new JMenuItem("Escolher estatisticas");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    escolherEstatisticas();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(menuItem);

        setJMenuBar(menuBar);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    fechar();
                } catch (IOException ex) {
                }
            }
        });

    }

    /**
     * Este método define a imagem de fundo da janela da interface gráfica.
     * @param url URL da imagem de fundo (localizaçao)
     * @return Imagem escolhida
     */
    public ImageIcon setImage(String url) {
        ClassLoader loaderClass = this.getClass().getClassLoader();
        java.net.URL urlImage = loaderClass.getResource(url);
        ImageIcon image = new ImageIcon(urlImage);
        return image;
    }

    /**
     * Este método contém todos os actionevent's associados a todas as funcionalidades
     * da interface gráfica.
     */

    private class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botaoSelCur) {
                cursoCorrente = ((BaseDadosCurso) list.getSelectedValue());
                p2.removeAll();
                p2.repaint();
                p2.validate();
            } else if (e.getSource() == butCriar) {
                try {
                    BaseDadosCurso b1 = new BaseDadosCurso(txtNome.getText(), txtSigla.getText(), Integer.parseInt(txtID.getText()), txtAno.getText());
                    dados.getCursos().adiciona(b1);
                    p2.removeAll();
                    p2.repaint();
                    p2.validate();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Por favor preencha a tabela com dados válidos", "Dados inválidos", JOptionPane.WARNING_MESSAGE);
                    p2.removeAll();
                    p2.repaint();
                    p2.validate();
                }
            } else if (e.getSource() == butCancelar) {
                p2.removeAll();
                p2.repaint();
                p2.validate();
            } else if (e.getSource() == botaoSelUC) {
                try {
                    ucCarrEpocaMan = ((UC) list.getSelectedValue());
                    cursoCorrente.carregaPautaManual(ucCarrEpocaMan, txtEpoca.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Não foi possível ler a pauta, verifique que todas as condições são cumpridas e volte a tentar", "Impossível ler", JOptionPane.ERROR_MESSAGE);
                    p2.removeAll();
                    p2.repaint();
                    p2.validate();
                }
                p2.removeAll();
                p2.repaint();
                p2.validate();
            } else if (e.getSource() == butEscolherEst) {
                t1.adicionaResCadeiras(cursoCorrente);
                if (est1.isSelected()) {
                    try {
                        t1.trataAmostra(cursoCorrente);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(GUI.this, "Não foi possível tratar as estatísticas devido ao seguinte erro", "Impossível ler", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (est2.isSelected()) {
                    try {
                        t1.trataResUcs(cursoCorrente);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(GUI.this, "Não foi possível tratar as estatísticas devido ao seguinte erro", "Impossível ler", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (est3.isSelected()) {
                    try {
                        t1.trataResAlunos(cursoCorrente);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(GUI.this, "Não foi possível tratar as estatísticas devido ao seguinte erro", "Impossível ler", JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(GUI.this, "Ficheiro guardado na pasta do projecto/src/estatisticas");
                p2.removeAll();
                p2.repaint();
                p2.validate();
            } else if (e.getSource() == botaoApaCur) {
                dados.getCursos().remove((BaseDadosCurso) list.getSelectedValue());
                p2.removeAll();
                p2.repaint();
                p2.validate();
            } else if (e.getSource() == botaoUCEpocas) {
                ucCarrEpocaMan = ((UC) list.getSelectedValue());
                p2.removeAll();
                p2.repaint();
                p2.validate();
                escolheEpocasUC();
            } else if (e.getSource() == botaoTrocaTrue) {
                try {
                    trocaBoo = list.getSelectedIndex();
                    ucCarrEpocaMan.getEpocas().remove(trocaBoo);
                    ucCarrEpocaMan.getEpocas().adiciona(true, trocaBoo);
                } catch (Exception ect) {
                    JOptionPane.showMessageDialog(GUI.this, "Não foi possível trocar os valores devido ao um erro", "Impossível ler", JOptionPane.ERROR_MESSAGE);
                }
                p2.removeAll();
                p2.repaint();
                p2.validate();
            } else if (e.getSource() == botaoTrocaFalse) {
                try {
                    trocaBoo = list.getSelectedIndex();
                    ucCarrEpocaMan.getEpocas().remove(trocaBoo);
                    ucCarrEpocaMan.getEpocas().adiciona(false, trocaBoo);
                } catch (Exception ect) {
                }
                p2.removeAll();
                p2.repaint();
                p2.validate();
            }
        }
    }

    /**
     * Este método questiona o utilizador se deseja, realmente, fechar a aplicação.
     */
    private void fechar() throws IOException {
        Object[] opSimNao = {"Sim", "Não"};
        if (JOptionPane.showOptionDialog(this, "Deseja fechar a aplicação?", "Estatísticas ISEP", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
            dados.gravaBaseDados();
            dispose();
        } else {
        }
    }
}
