/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descontos;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bessa
 */
public class DescFactory {
    private static DescFactory inst = new DescFactory();
    
    private DescFactory(){
        try{
            FileInputStream prop_file=new FileInputStream("Descontos.config");
            Properties prop=new Properties(System.getProperties());
            prop.load(prop_file);
            System.setProperties(prop);
        }catch(Exception e){
            System.setProperty("Descontos", "descontos.D1Adapter");
        }
    }
    
    public static DescFactory getInstance(){
        return inst;
    }

    public IDesc getDesconto() {
        String strClassName=System.getProperty("Descontos");
        try{
            return (IDesc) Class.forName(strClassName).newInstance();
        }catch(Exception e){
            Logger.getLogger("Rent-a-car").log(Level.SEVERE,null,e);
            return null;
        }
    }
}
