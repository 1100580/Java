package PonG;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Bastao{
    
    private JLabel bastao = new JLabel();

    public Bastao(){
        bastao.setBounds(60, 100, 10, 50);
        bastao.setVisible(true);
    }
    
    public JLabel getBastao(){
        return bastao;
    }
}
