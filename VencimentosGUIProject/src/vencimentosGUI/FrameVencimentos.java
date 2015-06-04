package vencimentosGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrameVencimentos extends JFrame {
    private ArrayList trabsList;
    
    public FrameVencimentos(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        
        menuBar = new JMenuBar();
        
        
        menu = new JMenu("Criação");
        menu.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Patrão",KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogPatrao dialog = new DialogPatrao(FrameVencimentos.this, "Criação de um novo Patrão");
                Patrao p = dialog.showDialog();
                if ( p != null )
                    trabsList.add( p );
            }
        });
        
        menu.add(menuItem);
        
        
        menuItem = new JMenuItem("Trabalhador à Comissão",KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogTrabCom dialog = new DialogTrabCom(FrameVencimentos.this, "Criação de um novo Trab. à Comissão");
                TrabCom tc = dialog.showDialog();
                if ( tc != null )
                    trabsList.add( tc );
            }
        });
        
        menu.add(menuItem);
        
        
        menuItem = new JMenuItem("Trabalhador à Hora",KeyEvent.VK_H);
        menuItem.setDisplayedMnemonicIndex(14);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogTrabHora dialog = new DialogTrabHora(FrameVencimentos.this, "Criação de um novo Trab. à Hora");
                TrabHora th = dialog.showDialog();
                if ( th != null )
                    trabsList.add( th );
            }
        });
        
        menu.add(menuItem);
        
        
        menu.addSeparator();
        
        menuItem = new JMenuItem("Sair",KeyEvent.VK_S);
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] opSimNao = {"Sim", "Não"};
                // 1º botão premido (Yes) -> devolve 0
                // 2º botão premido (No)  -> devolve 1
                if ( JOptionPane.showOptionDialog( FrameVencimentos.this, "Deseja fechar a aplicação?", "Gestão de Vencimentos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1] )  ==  0 )
                    FrameVencimentos.this.dispose();
            }
        });
        
        menu.add(menuItem);

        
        menu = new JMenu("Manutenção");
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);        
        
        menuItem = new JMenuItem("Alterar",KeyEvent.VK_A);
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( trabsList.size() == 0 )
                    JOptionPane.showMessageDialog(null, "Não existem trabalhadores.", "Gestão de Vencimentos", JOptionPane.INFORMATION_MESSAGE);
                else {
                    Object[] opcoes = new Object[trabsList.size()];
                    for (int i=0; i<trabsList.size(); i++)
                        opcoes[i] = trabsList.get(i);

                    Object obj = JOptionPane.showInputDialog(FrameVencimentos.this, "Escolha o trabalhador:", "Alteração de dados", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                    if (obj != null) {
                        if (obj instanceof Patrao) {
                            DialogPatrao dialog = new DialogPatrao(FrameVencimentos.this, "Alteração de dados");
                            Patrao p = dialog.showDialog((Trabalhador) obj);
                            if ( p != null )
                                trabsList.set( trabsList.indexOf(obj), p );
                        }
                        else if (obj instanceof TrabCom) {
                            DialogTrabCom dialog = new DialogTrabCom(FrameVencimentos.this, "Alteração de dados");
                            TrabCom tc = dialog.showDialog((Trabalhador) obj);
                            if ( tc != null )
                                trabsList.set( trabsList.indexOf(obj), tc );
                        }
                        else if (obj instanceof TrabHora) {
                            DialogTrabHora dialog = new DialogTrabHora(FrameVencimentos.this, "Alteração de dados");
                            TrabHora th = dialog.showDialog((Trabalhador) obj);
                            if ( th != null )
                                trabsList.set( trabsList.indexOf(obj), th );
                        }
                    }
                }
            }
        });
        
        menu.add(menuItem);

        
        menuItem = new JMenuItem("Eliminar",KeyEvent.VK_E);
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( trabsList.size() == 0 )
                    JOptionPane.showMessageDialog(null, "Não existem trabalhadores.", "Gestão de Vencimentos", JOptionPane.INFORMATION_MESSAGE);
                else {
                    Object[] opSimNao = {"Sim", "Não"};
                    // 1º botão premido (Yes) -> devolve 0
                    // 2º botão premido (No)  -> devolve 1

                    Object[] opcoes = new Object[trabsList.size()];
                    for (int i=0; i<trabsList.size(); i++)
                        opcoes[i] = trabsList.get(i);

                    Object obj = JOptionPane.showInputDialog(FrameVencimentos.this, "Escolha o trabalhador:", "Eliminação", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                    if (obj != null) {
                        if (JOptionPane.showOptionDialog(FrameVencimentos.this, "Tem a certeza?", "Eliminação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0)
                            trabsList.remove(obj);
                    }
                }
            }
        });
        
        menu.add(menuItem);
        
        
        menu = new JMenu("Gestão");
        menu.setMnemonic('G');
        menuBar.add(menu);        
        
        menuItem = new JMenuItem("Listar",KeyEvent.VK_L);
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogListar dialog = new DialogListar(FrameVencimentos.this, "Listagem de Trabalhadores", trabsList);
                dialog.showDialog();
            }
        });
        
        menu.add(menuItem);
        
        
        menuItem = new JMenuItem("Calcular Vencimento",KeyEvent.VK_V);
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogCalcularVencimento dialog = new DialogCalcularVencimento(FrameVencimentos.this, "Calcular Vencimento", trabsList);
                dialog.showDialog();
            }
        });
        
        menu.add(menuItem);
        
        
        setJMenuBar(menuBar);
        
        trabsList = new ArrayList();
        trabsList.add( new Patrao("Jorge Silva", 800.00f) );
        trabsList.add(new TrabCom("Susana Ferreira", 400.00f, 1500.00f, 0.06f));
        trabsList.add( new TrabHora("Carlos Miguel", 160, 3.00f) );
    }
    
}
