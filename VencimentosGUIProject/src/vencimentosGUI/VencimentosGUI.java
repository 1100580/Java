package vencimentosGUI;

import javax.swing.*;
import java.awt.*;

public class VencimentosGUI {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
            FrameVencimentos app = new FrameVencimentos("Gestão de Vencimentos");

            app.setSize(300,200);
            app.setMinimumSize(new Dimension(300,200));
            app.setLocation(200,200);
            app.setVisible(true);
        }
        catch(Exception cnfe) {
            cnfe.printStackTrace();
        }
    }
}
