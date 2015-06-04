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
        
        
        menu = new JMenu("Cria��o");
        menu.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Patr�o",KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogPatrao dialog = new DialogPatrao(FrameVencimentos.this, "Cria��o de um novo Patr�o");
                Patrao p = dialog.showDialog();
                if ( p != null )
                    trabsList.add( p );
            }
        });
        
        menu.add(menuItem);
        
        
        menuItem = new JMenuItem("Trabalhador � Comiss�o",KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogTrabCom dialog = new DialogTrabCom(FrameVencimentos.this, "Cria��o de um novo Trab. � Comiss�o");
                TrabCom tc = dialog.showDialog();
                if ( tc != null )
                    trabsList.add( tc );
            }
        });
        
        menu.add(menuItem);
        
        
        menuItem = new JMenuItem("Trabalhador � Hora",KeyEvent.VK_H);
        menuItem.setDisplayedMnemonicIndex(14);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogTrabHora dialog = new DialogTrabHora(FrameVencimentos.this, "Cria��o de um novo Trab. � Hora");
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
                Object[] opSimNao = {"Sim", "N�o"};
                // 1� bot�o premido (Yes) -> devolve 0
                // 2� bot�o premido (No)  -> devolve 1
                if ( JOptionPane.showOptionDialog( FrameVencimentos.this, "Deseja fechar a aplica��o?", "Gest�o de Vencimentos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1] )  ==  0 )
                    FrameVencimentos.this.dispose();
            }
        });
        
        menu.add(menuItem);

        
        menu = new JMenu("Manuten��o");
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);        
        
        menuItem = new JMenuItem("Alterar",KeyEvent.VK_A);
        
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if( trabsList.size() == 0 )
                    JOptionPane.showMessageDialog(null, "N�o existem trabalhadores.", "Gest�o de Vencimentos", JOptionPane.INFORMATION_MESSAGE);
                else {
                    Object[] opcoes = new Object[trabsList.size()];
                    for (int i=0; i<trabsList.size(); i++)
                        opcoes[i] = trabsList.get(i);

                    Object obj = JOptionPane.showInputDialog(FrameVencimentos.this, "Escolha o trabalhador:", "Altera��o de dados", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                    if (obj != null) {
                        if (obj instanceof Patrao) {
                            DialogPatrao dialog = new DialogPatrao(FrameVencimentos.this, "Altera��o de dados");
                            Patrao p = dialog.showDialog((Trabalhador) obj);
                            if ( p != null )
                                trabsList.set( trabsList.indexOf(obj), p );
                        }
                        else if (obj instanceof TrabCom) {
                            DialogTrabCom dialog = new DialogTrabCom(FrameVencimentos.this, "Altera��o de dados");
                            TrabCom tc = dialog.showDialog((Trabalhador) obj);
                            if ( tc != null )
                                trabsList.set( trabsList.indexOf(obj), tc );
                        }
                        else if (obj instanceof TrabHora) {
                            DialogTrabHora dialog = new DialogTrabHora(FrameVencimentos.this, "Altera��o de dados");
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
                    JOptionPane.showMessageDialog(null, "N�o existem trabalhadores.", "Gest�o de Vencimentos", JOptionPane.INFORMATION_MESSAGE);
                else {
                    Object[] opSimNao = {"Sim", "N�o"};
                    // 1� bot�o premido (Yes) -> devolve 0
                    // 2� bot�o premido (No)  -> devolve 1

                    Object[] opcoes = new Object[trabsList.size()];
                    for (int i=0; i<trabsList.size(); i++)
                        opcoes[i] = trabsList.get(i);

                    Object obj = JOptionPane.showInputDialog(FrameVencimentos.this, "Escolha o trabalhador:", "Elimina��o", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                    if (obj != null) {
                        if (JOptionPane.showOptionDialog(FrameVencimentos.this, "Tem a certeza?", "Elimina��o", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0)
                            trabsList.remove(obj);
                    }
                }
            }
        });
        
        menu.add(menuItem);
        
        
        menu = new JMenu("Gest�o");
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
