/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Hello;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author i090674
 */
public class Hello extends JFrame{

   
    public Hello(String titulo){
        super(titulo);
        Container c = new Container();
        c = getContentPane();
        c.setBackground(Color.lightGray);
        BorderLayout b = new BorderLayout();
        JLabel j = new JLabel();
        j.setForeground(Color.BLUE);
        j.setText("Hello World!");           
        c.setLayout(b);
        j.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(j,BorderLayout.CENTER);


                
    }
    public static void main(String[] args) {
       Hello h = new Hello("Hello");
       h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       h.setVisible(true);
       h.setSize(500,500);
       
       
    }

}
