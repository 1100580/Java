package fisica;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import java.io.*;

public class GUI extends JFrame {

    public GUI() {
        
        super("Calculadora Física");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JMenuBar j1 = new JMenuBar();
        JMenu menu,submenu;
        JMenuItem menuItem;        
        menu = new JMenu("Calculadora");
        menuItem  = new JMenuItem("1ª Lei da Termodinâmica");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {               
                    int c1 = 0;
                    int calor = Integer.parseInt(JOptionPane.showInputDialog("Q (Calor)", c1));
                    int c2 = 0;
                    int temperatura = Integer.parseInt(JOptionPane.showInputDialog("W (Trabalho)", c2));
                    int res = PrimLeiTermo(calor,temperatura);                    
                    JOptionPane.showMessageDialog(null, res);                    
            }
        });
        menu.add(menuItem);
        
        menuItem  = new JMenuItem("2ª Lei da Termodinâmica");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {               
                    int c1 = 0;
                    int calor = Integer.parseInt(JOptionPane.showInputDialog("Q1 (Fonte Quente)", c1));
                    int c2 = 0;
                    int temperatura = Integer.parseInt(JOptionPane.showInputDialog("Q2 (Fonte Fria)", c2));
                    int res = SegunLeiTermo(calor,temperatura);                    
                    JOptionPane.showMessageDialog(null, res);                    
            }
        });
        menu.add(menuItem); 
        
        menuItem  = new JMenuItem("Lei de Fourier");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {               
                    int c1 = 0;
                    int k = Integer.parseInt(JOptionPane.showInputDialog("K (Condutividade térmica do material)", c1));
                    int c2 = 0;
                    int area = Integer.parseInt(JOptionPane.showInputDialog("A (Área)", c2));
                    int c3 = 0;
                    int t = Integer.parseInt(JOptionPane.showInputDialog("ΔT (Diferença de temperatura)", c3));
                    int c4 = 0;
                    int x = Integer.parseInt(JOptionPane.showInputDialog("Δx (Espessura dada para o material)" , c4));
                    int res = LeiFourier(k,area,t,x);                    
                    JOptionPane.showMessageDialog(null, res);                    
            }
        });
        menu.add(menuItem);                
        
        menuItem  = new JMenuItem("Resistência Térmica");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {               
                    int c1 = 0;
                    int l = Integer.parseInt(JOptionPane.showInputDialog("l (Espessura)", c1));
                    int c2 = 0;
                    int k = Integer.parseInt(JOptionPane.showInputDialog("K (Condutividade térmica do material)", c2));
                    int c3 = 0;
                    int area = Integer.parseInt(JOptionPane.showInputDialog("A (Área)", c3));                    
                    int res = ResisTerm(l,k,area);                    
                    JOptionPane.showMessageDialog(null, res);                    
            }
        });
        menu.add(menuItem);
        
        menu.addSeparator();
       
        menuItem  = new JMenuItem("Sair");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fechar();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(menuItem);        
        j1.add(menu);
        
        menu = new JMenu("Formulário");
        submenu = new JMenu("Fórmulas");
        menuItem = new JMenuItem("1ª Lei da Termodinâmica");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {  
                JOptionPane.showMessageDialog(null, "\n ∆u = Q-W"
                        + " \n Q - Calor "
                        + " \n W - Trabalho"
                        + " \n u - Energia Interna"
                        + " \n S.I. - J(Joules)");                                       
            }
        });
        submenu.add(menuItem);        
       
        menuItem = new JMenuItem("2ª Lei da Termodinâmica");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {  
                JOptionPane.showMessageDialog(null, "\n W = Q1-Q2"
                        + " \n Q1 - Fonte Quente "
                        + " \n Q2 - Fonte Fria");                                                            
            }
        });
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Lei de Fourier (Cálculo de transferência de calor)");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {  
                JOptionPane.showMessageDialog(null, "\n ΔQ/Δt = κA (ΔT/Δx)"
                        + " \n k - Condutividade térmica do material"
                        + " \n A - Área"
                        + " \n ∆T - Diferença de temperatura "
                        + " \n ∆x - Espessura do material");                                                            
            }
        });
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Resistência Térmica");
        menuItem.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {  
                JOptionPane.showMessageDialog(null, "\n RT = l/(k*A)"
                        + " \n l - Espessura do material"
                        + " \n k - Condutividade térmica do material"
                        + " \n A - Área");                                                            
            }
        });
        submenu.add(menuItem);
        
        menu.add(submenu);       
        j1.add(menu);
        setJMenuBar(j1);
    }
    
    
         
    public int PrimLeiTermo(int c1, int c2){
        int res=0;
        res = c1-c2;
        return res;
    }
    
    public int SegunLeiTermo(int c1, int c2){
        int res=0;
        res = c1-c2;
        return res;
    }
    
    public int LeiFourier(int c1, int c2, int c3, int c4){
        int res1=0;
        int res2=0;
        int res3=0;
        res1 = c1*c2;
        res2 = c3/c4;
        res3 = res1 * res2;
        return res3;
    }
    
    public int ResisTerm(int c1, int c2, int c3){
        int res=0;
        res = c1/(c2*c3);
        return res;
    }
     
     
    
    private void fechar() throws IOException {
        Object[] opSimNao = {"Sim", "Não"};
        if (JOptionPane.showOptionDialog(this, "Deseja fechar a aplicação?", "Estatísticas ISEP", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]) == 0) {
            dispose();
        }
    }

}
